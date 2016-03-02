package homo.efficio.udemy.ecommerce.music.controller;

import homo.efficio.udemy.ecommerce.music.dao.ProductDao;
import homo.efficio.udemy.ecommerce.music.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Created by hanmomhanda on 16. 3. 2.
 */
@Controller
public class AdminController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    private ProductDao productDao;

    private final String IMAGES_DIR = "images";

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        return "productInventory";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductCategory("Instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");

        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product,
                                 BindingResult bindingResult,
                                 HttpServletRequest request) {
Map parameterMap = request.getParameterMap();
        if (bindingResult.hasErrors()) {
            return "addProduct";
        }

        MultipartFile productImage = product.getProductImage();
        saveToFile(productImage);
        product.setProductImageWebPath(getImageWebDir(productImage.getOriginalFilename()));
        productDao.addProduct(product);
        return "redirect:/admin/productInventory";
    }

    private Path getImagePath(MultipartFile multipartFile) {
        return Paths.get(getImagePhysicalDir() + "/" + multipartFile.getOriginalFilename());
    }

    private String getImagePhysicalDir() {
        return servletContext.getRealPath("/WEB-INF/" + IMAGES_DIR);
    }

    private String getImageWebDir(String fileName) {
        return servletContext.getContextPath() + "/" + IMAGES_DIR + "/" + fileName;
    }

    @RequestMapping("/admin/productInventory/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        Product product = productDao.getProductById(productId);
        String imageWebPath = product.getProductImageWebPath();
        String fileName = imageWebPath.substring(imageWebPath.lastIndexOf('/')+1);
        String imagePath = getImagePhysicalDir() + "/" + fileName;

        File file = new File(imagePath);
        if (file.exists()) {
            file.delete();
        }

        productDao.deleteProduct(productId);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        Product product = productDao.getProductById(id);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editProduct";
        }
        MultipartFile productImage = product.getProductImage();
        if (!productImage.isEmpty()) {
            saveToFile(productImage);
            product.setProductImageWebPath(getImageWebDir(productImage.getOriginalFilename()));
        }

        productDao.editProduct(product);

        return "redirect:/admin/productInventory";
    }

    private void saveToFile(MultipartFile multipartFile) {
        Path path = getImagePath(multipartFile);
        String imageFullPath = path.toString();
        if (multipartFile != null && !multipartFile.isEmpty()) {
            try {
                multipartFile.transferTo(new File(imageFullPath));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                throw new RuntimeException("EncodingType is wrong.", e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);
            }
        }
    }
}

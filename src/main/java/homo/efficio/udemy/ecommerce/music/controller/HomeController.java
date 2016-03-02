package homo.efficio.udemy.ecommerce.music.controller;

import homo.efficio.udemy.ecommerce.music.dao.ProductDao;
import homo.efficio.udemy.ecommerce.music.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by hanmomhanda on 16. 2. 26.
 */
@Controller
public class HomeController {


    @Autowired
    private ProductDao productDao;


    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model) {
        List<Product> productList = productDao.getAllProducts();
        model.addAttribute("products", productList);
        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable Long productId, Model model) {
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);
        return "viewProduct";
    }


}

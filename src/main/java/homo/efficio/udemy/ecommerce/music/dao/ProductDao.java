package homo.efficio.udemy.ecommerce.music.dao;

import homo.efficio.udemy.ecommerce.music.model.Product;

import java.util.List;

/**
 * Created by hanmomhanda on 16. 2. 28.
 */
public interface ProductDao {

    void addProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    void deleteProduct(Long id);

    void editProduct(Product product);
}

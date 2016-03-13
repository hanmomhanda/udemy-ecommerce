package homo.efficio.udemy.ecommerce.music.model;

import lombok.Data;

/**
 * Created by hanmomhanda on 16. 3. 12.
 */
@Data
public class CartItem {

    private Product product;
    private int quantity;
    private double totalPrice;

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.totalPrice = product.getProductPrice();
    }
}

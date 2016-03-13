package homo.efficio.udemy.ecommerce.music.model;

import lombok.Data;

import java.util.Map;

/**
 * Created by hanmomhanda on 16. 3. 12.
 */
@Data
public class Cart {

    private String cartId;
    private Map<Long, CartItem> cartItems;
    private double grandTotal;

    public Cart(String cartId) {
        this.cartId = cartId;
    }

    public void addCartItem(CartItem cartItem) {
        Long productId = cartItem.getProduct().getProductId();

        if (cartItems.containsKey(productId)) {
            CartItem existingCartItem = cartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItem.getQuantity());
            cartItems.put(productId, existingCartItem);
        } else {
            cartItems.put(productId, cartItem);
        }

        updateGrandTotal();
    }

    public void removeCartItem(CartItem cartItem) {
        Long productId = cartItem.getProduct().getProductId();
        cartItems.remove(productId);
        updateGrandTotal();
    }

    private void updateGrandTotal() {
        grandTotal = 0;
        for (CartItem item : cartItems.values()) {
            grandTotal += item.getTotalPrice();
        }
    }
}

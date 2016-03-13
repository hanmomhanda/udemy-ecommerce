package homo.efficio.udemy.ecommerce.music.dao;

import homo.efficio.udemy.ecommerce.music.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by hanmomhanda on 16. 3. 12.
 */
@Repository
public class CartDaoImpl implements CartDao {

    private Map<String, Cart> listOfCarts;

    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(
                    String.format("Cannot create a cart. A cart with the given id(%) already exists.", cart.getCartId())
            );
        }

        listOfCarts.put(cart.getCartId(), cart);

        return cart;
    }

    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    public void update(String cartId, Cart cart) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(
                    String.format("Cannot update a cart. A cart with the given id(%) does NOT exists.", cartId)
            );
        }

        listOfCarts.put(cartId, cart);
    }

    public void delete(String cartId) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(
                    String.format("Cannot delete a cart. A cart with the given id(%) does NOT exists.", cartId)
            );
        }

        listOfCarts.remove(cartId);
    }
}

package homo.efficio.udemy.ecommerce.music.dao;

import homo.efficio.udemy.ecommerce.music.model.Cart;

/**
 * Created by hanmomhanda on 16. 3. 12.
 */
public interface CartDao {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);
}

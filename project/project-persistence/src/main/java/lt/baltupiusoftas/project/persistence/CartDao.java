package lt.baltupiusoftas.project.persistence;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.User;

import java.util.List;

/**
 * Product DAO
 *
 * @author Audrius Tvarijonas
 */
public interface CartDao extends GenericDao<Cart> {

    List<Cart> findAllCartsForPurchaseHistory(User user);
    Cart findActiveCart(Long userId);
}

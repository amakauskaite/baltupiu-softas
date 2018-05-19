package lt.baltupiusoftas.project.persistence;

import lt.baltupiusoftas.project.domain.Cart;

/**
 * Product DAO
 *
 * @author Audrius Tvarijonas
 */
public interface CartDao extends GenericDao<Cart> {

    Cart findActiveCart(Long userId);
}

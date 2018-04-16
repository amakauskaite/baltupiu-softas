package lt.baltupiusoftas.project.persistence;

import lt.baltupiusoftas.project.domain.Cart;

import java.util.List;

/**
 * Product DAO
 *
 * @author Audrius Tvarijonas
 */
public interface CartDao extends GenericDao<Cart> {

    List<Cart> findUserCarts(Long userId);
}

package lt.baltupiusoftas.project.persistence;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Product DAO
 *
 * @author Audrius Tvarijonas
 */
public interface CartDao extends GenericDao<Cart> {

    List<Cart> findUserCarts(Long userId);
    List<Cart> findAllCartsForPurchaseHistory(User user);
}

package lt.baltupiusoftas.project.persistence.impl;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.persistence.CartDao;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Cart DAO
 *
 * @author Audrius Tvarijonas
 */
public class CartDaoImpl extends GenericDaoImpl<Cart> implements CartDao {

    @Override
    public List<Cart> findUserCarts(Long userId) {
        String findUserCart = "select cart " +
                "from Cart cart " +
                "where cart.user.id = :userId";

        TypedQuery<Cart> query = entityManager.createQuery(findUserCart, Cart.class);
        query.setParameter("userId", userId);

        return query.getResultList();
    }
}

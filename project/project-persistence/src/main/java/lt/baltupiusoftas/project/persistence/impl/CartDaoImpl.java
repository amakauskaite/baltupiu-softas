package lt.baltupiusoftas.project.persistence.impl;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.persistence.CartDao;

import javax.persistence.TypedQuery;

/**
 * Cart DAO
 *
 * @author Audrius Tvarijonas
 */
public class CartDaoImpl extends GenericDaoImpl<Cart> implements CartDao {

    @Override
    public Cart findActiveCart(Long userId) {
        String findActiveCart = "select cart " +
                "from Cart cart " +
                "where cart.user.id = :userId " +
                "order by cart.id desc";

        TypedQuery<Cart> query = entityManager.createQuery(findActiveCart, Cart.class);
        query.setParameter("userId", userId);
        query.setMaxResults(1);

        return query.getSingleResult();
    }
}

package lt.baltupiusoftas.project.persistence.impl;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.persistence.CartDao;
import lt.baltupiusoftas.project.persistence.UserDao;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Cart DAO
 *
 * @author Audrius Tvarijonas
 */
public class CartDaoImpl extends GenericDaoImpl<Cart> implements CartDao {

    @Inject
    private UserDao userDao;

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


    @Override
    public List<Cart> findUserHistory(Long userId){
        String findUserHistory = "select cart" +
                "from Cart cart" +
                "where cart.user.id = :userId";


        TypedQuery<Cart> query = entityManager.createQuery(findUserHistory, Cart.class);
        query.setParameter("userId", userId);
        List<Cart> results = query.getResultList();

        return results;
    }

    @Override
    public List<Cart> findAllCarts() {
        String findCarts= "select cart" +
                "from Cart cart";


        TypedQuery<Cart> query = entityManager.createQuery(findCarts, Cart.class);

        return query.getResultList();
    }
}
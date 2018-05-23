package lt.baltupiusoftas.project.persistence.impl;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.persistence.CartDao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Cart DAO
 *
 * @author Audrius Tvarijonas
 */

public class CartDaoImpl extends GenericDaoImpl<Cart> implements CartDao{

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
    public List<Cart> findAllCartsForPurchaseHistory(User user){
        String findAllCartsForPurchaseHistory = "select cart" +
                "from Cart cart" +
                "where cart.user = :user and orderStatusType = 'COMPLETED'";


        TypedQuery<Cart> query = entityManager.createQuery(findAllCartsForPurchaseHistory, Cart.class);
        query.setParameter("user", user);

        return query.getResultList();
    }
}

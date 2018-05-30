package lt.baltupiusoftas.project.persistence.impl;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.types.OrderStatusType;
import lt.baltupiusoftas.project.persistence.CartDao;
import lt.baltupiusoftas.project.persistence.UserDao;

import javax.inject.Inject;
import javax.persistence.NoResultException;
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

    private OrderStatusType incomplete = OrderStatusType.INCOMPLETE;

    @Override
    public Cart findActiveCart(Long userId) {
        String findActiveCart = "select cart " +
                "from Cart cart " +
                "where cart.user.id = :userId AND cart.orderStatus = :orderStatus " +
                "order by cart.id desc";

        TypedQuery<Cart> query = entityManager.createQuery(findActiveCart, Cart.class);
        query.setParameter("userId", userId);
        query.setParameter("orderStatus", incomplete);
        query.setMaxResults(1);
        Cart cart;
        try {
            cart = query.getSingleResult();
        } catch (NoResultException exception) {
            cart = new Cart();
            cart.setUser(userDao.find(userId));
            create(cart);
        }

        return cart;
    }


    @Override
    public List<Cart> findUserHistory(Long userId){
        String findUserHistory = "select c " +
                "from Cart c " +
                "where c.user.id = :userId AND c.items.size > 0 AND c.orderStatus != :orderStatus";


        TypedQuery<Cart> query = entityManager.createQuery(findUserHistory, Cart.class);
        query.setParameter("userId", userId);
        query.setParameter("orderStatus", incomplete);
        return query.getResultList();

    }

    @Override
    public List<Cart> findAllCarts() {
        String findCarts= "select c " +
                "from Cart c where c.items.size > 0 AND c.orderStatus != :orderStatus" ;


        TypedQuery<Cart> query = entityManager.createQuery(findCarts, Cart.class);
        query.setParameter("orderStatus", incomplete);

        return query.getResultList();
    }
}
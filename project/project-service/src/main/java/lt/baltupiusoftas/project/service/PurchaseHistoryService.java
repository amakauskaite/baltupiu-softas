package lt.baltupiusoftas.project.service;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.CartItem;
import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.types.OrderStatusType;
import lt.baltupiusoftas.project.persistence.CartDao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class PurchaseHistoryService {
    @Inject
    private CartDao cartDAO;

    public Cart createList (List<CartItem> items, OrderStatusType orderStatus){
        Cart cart = new Cart();
        cart.setItems(items);
        cartDAO.create(cart);
        return cart;
    }

    public List<Cart> findAllCartsForPurchaseHistory(User user){
        return cartDAO.findAllCartsForPurchaseHistory(user);


    }
}

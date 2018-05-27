package lt.baltupiusoftas.project.service.impl;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.types.OrderStatusType;
import lt.baltupiusoftas.project.persistence.CartDao;
import lt.baltupiusoftas.project.service.CartService;

import javax.inject.Inject;

public class CartServiceImpl implements CartService {

    @Inject
    private CartDao cartDao;

    @Override
    public Cart findActiveCart(Long userId) {
        return cartDao.findActiveCart(userId);
    }

    //todo implement
    @Override
    public Cart addOldCart(Long cartId) {
        return null;
    }

    @Override
    public Cart updateCartStatus(Long cartId) {
        Cart cart = cartDao.find(cartId);
        cart.setOrderStatus(OrderStatusType.COMPLETED);
        return cartDao.update(cart);
    }

    @Override
    public Boolean isStatusUpdatable(Long cartId) {
        Cart cart = cartDao.find(cartId);
        return cart.getOrderStatus() == OrderStatusType.INCOMPLETE;
    }
}

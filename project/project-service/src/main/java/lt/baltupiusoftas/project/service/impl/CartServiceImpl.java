package lt.baltupiusoftas.project.service.impl;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.CartItem;
import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.domain.types.OrderStatusType;
import lt.baltupiusoftas.project.persistence.CartDao;
import lt.baltupiusoftas.project.persistence.ProductDao;
import lt.baltupiusoftas.project.service.CartService;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public class CartServiceImpl implements CartService {

    @Inject
    private CartDao cartDao;

    @Inject
    ProductDao productDao;


    @Override
    public Cart findActiveCart(Long userId) {
        return cartDao.findActiveCart(userId);
    }

    @Override
    public Cart addOldCart(Long cartId) {
        Cart cart = cartDao.find(cartId);
        Cart activeCart = cartDao.findActiveCart(cart.getUser().getId());
        List <CartItem> oldItems = cart.getItems();
        List<CartItem> activeItems = activeCart.getItems();
        for (CartItem i : oldItems) {
            Long productId = i.getProduct().getId();
            Product product = productDao.find(productId);
            if (product != null) {
                CartItem item = new CartItem();
                item.setPrice(product.getPrice());
                item.setProduct(product);
                activeItems.add(item);
            }
        }
        activeCart.setItems(activeItems);
        return cartDao.update(activeCart);
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

    @Override
    public BigDecimal countCartSum(List<CartItem> items) {
        BigDecimal sum = BigDecimal.ZERO;
        for (CartItem i: items) {
            sum = sum.add(i.getPrice());
        }

        return sum;
    }
}

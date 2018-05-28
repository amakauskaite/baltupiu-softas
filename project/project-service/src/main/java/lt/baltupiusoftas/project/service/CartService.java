package lt.baltupiusoftas.project.service;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.CartItem;

import java.math.BigDecimal;
import java.util.List;

import java.math.BigDecimal;

/**
 * Cart service
 *
 * @author Audrius Tvarijonas
 */
public interface CartService {

    /**
     * Finds active cart by user id
     *
     * @param userId userId
     * @return active cart
     */
    Cart findActiveCart(Long userId);
    BigDecimal cartPrice(Cart cart);

    Cart updateCart(Cart cart);
    Cart addOldCart(Long cartId);
    Cart updateCartStatus (Long cartId);
    Boolean isStatusUpdatable (Long cartId);
    BigDecimal countCartSum (List <CartItem> items);
}

package lt.baltupiusoftas.project.service;

import lt.baltupiusoftas.project.domain.Cart;

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
}

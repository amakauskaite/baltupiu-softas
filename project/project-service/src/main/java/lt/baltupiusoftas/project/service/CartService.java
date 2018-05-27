package lt.baltupiusoftas.project.service;

import lt.baltupiusoftas.project.domain.Cart;

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
    Cart addOldCart(Long cartId);
    Cart updateCartStatus (Long cartId);
    Boolean isStatusUpdatable (Long cartId);
}

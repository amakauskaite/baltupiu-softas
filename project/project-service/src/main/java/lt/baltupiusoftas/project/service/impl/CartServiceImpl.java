package lt.baltupiusoftas.project.service.impl;

import lt.baltupiusoftas.project.domain.Cart;
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
}

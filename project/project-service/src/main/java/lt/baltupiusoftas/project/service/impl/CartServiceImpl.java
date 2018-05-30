package lt.baltupiusoftas.project.service.impl;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.persistence.CartDao;
import lt.baltupiusoftas.project.service.CartService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;

public class CartServiceImpl implements CartService {

    @Inject
    private CartDao cartDao;

    @Transactional
    @Override
    public Cart findActiveCart(Long userId) {
        return cartDao.findActiveCart(userId);
    }

    @Transactional
    @Override
    public BigDecimal cartPrice(Cart cart) {
        return cart.getItems().stream().map(i -> i.getProduct().getPrice().multiply(i.getCount())).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Transactional
    @Override
    public Cart updateCart(Cart cart) {
        return cartDao.update(cart);
    }
}

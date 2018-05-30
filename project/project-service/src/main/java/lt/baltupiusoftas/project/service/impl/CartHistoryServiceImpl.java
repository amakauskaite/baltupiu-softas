package lt.baltupiusoftas.project.service.impl;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.persistence.CartDao;
import lt.baltupiusoftas.project.service.CartHistoryService;

import javax.inject.Inject;
import java.util.List;

public class CartHistoryServiceImpl implements CartHistoryService {
    @Inject
    private CartDao cartDAO;

    @Override
    public List<Cart> findUserHistory(Long userId) {
        return cartDAO.findUserHistory(userId);
    }

    @Override
    public List<Cart> findAllCarts() {
        return cartDAO.findAllCarts();
    }



}

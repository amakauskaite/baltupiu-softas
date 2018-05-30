package lt.baltupiusoftas.project.service;

import lt.baltupiusoftas.project.domain.Cart;

import java.util.List;

public interface CartHistoryService {
    List<Cart> findUserHistory(Long userid);
    List<Cart> findAllCarts ();
}

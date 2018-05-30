package lt.baltupiusoftas.project.app.cart_history;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.service.CartHistoryService;
import lt.baltupiusoftas.project.service.CartService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Model
public class AdministratorCartBean {

    private List<Cart> carts;

    @Inject
    private CartHistoryService cartHistoryService;

    @Inject
    private CartService cartService;

    @PostConstruct
    @Transactional
    public void init () {
        carts = cartHistoryService.findAllCarts();
    }


    @Transactional
    public String updateCartStatus (Long cartId) {
        Cart cart = cartService.updateCartStatus (cartId);
       return "adminOrders";
    }

    public Boolean isStatusUpdatable (Long cartId) {
        return cartService.isStatusUpdatable (cartId);
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    @Transactional
    public BigDecimal countCartPrice (Cart cart) {
        return cartService.cartPrice(cart).setScale(2, BigDecimal.ROUND_UNNECESSARY);
    }


}

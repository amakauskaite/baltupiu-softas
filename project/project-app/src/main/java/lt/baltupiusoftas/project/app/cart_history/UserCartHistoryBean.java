package lt.baltupiusoftas.project.app.cart_history;

import lt.baltupiusoftas.project.app.Login;
import lt.baltupiusoftas.project.app.ManageCartBean;
import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.CartHistoryService;
import lt.baltupiusoftas.project.service.CartService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.TransientReference;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class UserCartHistoryBean {

    @Inject
    private Login login;

    @Inject
    private CartHistoryService cartHistoryService;

    @Inject
    private CartService cartService;

    @Inject
    private ManageCartBean manageCartBean;

    private List <Cart> carts;

    @Transactional(Transactional.TxType.REQUIRED)
    @PostConstruct
    public void init () {

        carts = cartHistoryService.findUserHistory(login.getUser().getId());
        if (carts.size() == 0) {
            carts = new ArrayList<>();
        }
    }

    @Transactional
    public void addCartAgain (Long cartId) {
        Cart cart = cartService.addOldCart(cartId);
        manageCartBean.setCart(cart);
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}

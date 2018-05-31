package lt.baltupiusoftas.project.app.cart_history;

import lt.baltupiusoftas.project.app.Login;
import lt.baltupiusoftas.project.app.cart.ManageCartBean;
import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.service.CartHistoryService;
import lt.baltupiusoftas.project.service.CartService;
import lt.baltupiusoftas.project.service.intersector.LoggedInvocation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
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

        try {
            carts = cartHistoryService.findUserHistory(login.getUser().getId());
                    }
        catch (NullPointerException npe)
        {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
            }
            catch (IOException ioe)
            {
                System.out.println("Failed to redirect to another page in "+this.getClass().getName());
            }

        }


    }

    @Transactional
    @LoggedInvocation
    public void addCartAgain (Long cartId) {
        Cart cart = cartService.addOldCart(cartId);
        manageCartBean.setCart(cart);
    }

    public BigDecimal countCartPrice(Cart cart) {
        return cartService.cartPrice(cart);
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}

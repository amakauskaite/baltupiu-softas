package lt.baltupiusoftas.project.app.cart_history;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.app.AdministratorLogin;
import lt.baltupiusoftas.project.app.administrator.AdministratorLoginBean;
import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.CartItem;
import lt.baltupiusoftas.project.service.CartHistoryService;
import lt.baltupiusoftas.project.service.CartService;
import lt.baltupiusoftas.project.service.intersector.LoggedInvocation;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Model
public class AdministratorCartBean {

    private List<Cart> carts;

    @Inject
    private CartHistoryService cartHistoryService;

    @Inject
    private CartService cartService;

    @Inject
    AdministratorLogin administratorLogin;

    @PostConstruct
    @Transactional
    public void init () {
        if(administratorLogin.getAdministrator() == null)
        {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
            }
            catch (IOException ioe)
            {
                System.out.println("Failed to redirect to another page in "+this.getClass().getName());
            }
        }
        carts = cartHistoryService.findAllCarts();
    }


    @Transactional
    @LoggedInvocation
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

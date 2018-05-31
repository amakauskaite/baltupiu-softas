package lt.baltupiusoftas.project.app.cart;

import lt.baltupiusoftas.project.app.Login;
import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.data.Payment;
import lt.baltupiusoftas.project.service.CartService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.math.BigDecimal;

/**
*/
@Model
public class PayCartBean {

    @Inject
    private Login login;

    @Inject
    private CartService cartService;

    private Payment payment;
    private Cart activeCart;

    @PostConstruct
    public void init() {
        activeCart = cartService.findActiveCart(login.getUser().getId());
        payment = new Payment();
        payment.setAmount(cartService.cartPrice(activeCart).setScale(2, BigDecimal.ROUND_UNNECESSARY).intValue());
    }

    public String payForCart() {
        Boolean success = cartService.pay(activeCart, payment);
        if (success) {
            return "purchaseHistory";
        } else {
            FacesContext.getCurrentInstance().addMessage("payBtn", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Klaida!",  "Nesėkmingas apmokėjimas"));
            return "cart";
        }


    }

    public BigDecimal calculateCartPrice() {
        return cartService.cartPrice(activeCart).setScale(2, BigDecimal.ROUND_UNNECESSARY);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Cart getActiveCart() {
        return activeCart;
    }

    public void setActiveCart(Cart activeCart) {
        this.activeCart = activeCart;
    }
}

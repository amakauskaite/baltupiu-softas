package lt.baltupiusoftas.project.app;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.CartItem;
import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.service.CartService;
import lt.baltupiusoftas.project.service.intersector.LoggedInvocation;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * Bean for cart view
 *
 * @author Audrius Tvarijonas
 */
@Model
public class ManageCartBean {

    @Inject
    private Login login;

    @Inject
    private CartService cartService;

    private Cart cart;

    @PostConstruct
    public void init() {
        cart = cartService.findActiveCart(login.getUser().getId());
    }

    public List<CartItem> getCartItems() {
        return cart.getItems();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @LoggedInvocation
    public void addProductToCart(Product product) {
        cart.getItems().add(new CartItem(product, BigDecimal.ONE));
        cartService.updateCart(cart);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  "Prekė "+product.getName()+" pridėta į krepšelį") );

    }

    public BigDecimal calculateCartPrice() {
        return cartService.cartPrice(cart).setScale(2, BigDecimal.ROUND_UNNECESSARY);
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

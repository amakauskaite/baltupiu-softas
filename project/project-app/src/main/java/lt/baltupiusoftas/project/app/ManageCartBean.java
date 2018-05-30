package lt.baltupiusoftas.project.app;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.CartItem;
import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.service.CartService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
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

    public String addProductToCart(Product product) {
        cart.getItems().add(new CartItem(product, BigDecimal.ONE));
        cartService.updateCart(cart);
        return "index";
    }

    public BigDecimal calculateCartPrice() {
        return cartService.cartPrice(cart);
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

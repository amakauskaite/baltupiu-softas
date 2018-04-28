package lt.baltupiusoftas.project.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lt.baltupiusoftas.project.domain.types.OrderStatusType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Cart
 *
 * @author Audrius Tvarijonas
 */
@Entity
@Table(name = "CART")
@NamedQueries({
        @NamedQuery(name="Cart.findAllCartsForPurchaseHistory",query="SELECT c FROM Cart c WHERE c.user = :user and orderStatusType = 'COMPLETED'"),
        @NamedQuery(name="Cart.findAllCarts",query="SELECT c FROM Cart c")
})
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CART_ID")
    private List<CartItem> items = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    private OrderStatusType orderStatus = OrderStatusType.INCOMPLETE;

    public Cart() {
    }

    public Cart(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public OrderStatusType getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusType orderStatus) {
        this.orderStatus = orderStatus;
    }
}

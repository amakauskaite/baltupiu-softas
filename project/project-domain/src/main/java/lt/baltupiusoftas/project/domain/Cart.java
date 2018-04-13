package lt.baltupiusoftas.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Cart
 *
 * @author Audrius Tvarijonas
 */
@Entity
@Table(name = "CART")
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartProduct> products;

    @Column(name = "STATUS")
    private String status;

    public Cart() {
    }

    public Cart(User user, List<CartProduct> products, String status) {
        this.user = user;
        this.products = products;
        this.status = status;
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

    public List<CartProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CartProduct> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

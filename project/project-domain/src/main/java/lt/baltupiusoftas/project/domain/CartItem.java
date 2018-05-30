package lt.baltupiusoftas.project.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Cart item
 *
 * @author Audrius Tvarijonas
 */
@Entity
@Table(name = "CART_ITEM")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    /**
     * Amount of money paid
     */
    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "COUNT")
    private BigDecimal count;

    public CartItem() {
    }

    public CartItem(Product product, BigDecimal count) {
        this.product = product;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}

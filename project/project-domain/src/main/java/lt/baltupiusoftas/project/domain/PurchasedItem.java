package lt.baltupiusoftas.project.domain;

import javax.persistence.*;

/**
 * Purchase history item
 *
 * @author Audrius Tvarijonas
 */
@Entity
@Table(name = "PURCHASED_ITEM")
public class PurchasedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PURCHASE_HISTORY_ID")
    private PurchaseHistory purchaseHistory;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "PRICE")
    private Integer price;

    public PurchasedItem() {
    }

    public PurchasedItem(PurchaseHistory purchaseHistory, Product product, Integer price) {
        this.purchaseHistory = purchaseHistory;
        this.product = product;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PurchaseHistory getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(PurchaseHistory purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

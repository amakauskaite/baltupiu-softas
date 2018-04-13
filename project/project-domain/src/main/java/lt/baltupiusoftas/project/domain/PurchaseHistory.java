package lt.baltupiusoftas.project.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Purchase history
 *
 * @author Audrius Tvarijonas
 */
@Entity
@Table(name = "PURCHASE_HISTORY)")
public class PurchaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "purchaseHistory", cascade = CascadeType.ALL)
    private List<PurchasedItem> purchasedItems;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PURCHASE_DATE")
    private Date purchaseDate;

    public PurchaseHistory() {
    }

    public PurchaseHistory(User user, List<PurchasedItem> purchasedItems, String status, Date purchaseDate) {
        this.user = user;
        this.purchasedItems = purchasedItems;
        this.status = status;
        this.purchaseDate = purchaseDate;
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

    public List<PurchasedItem> getPurchasedItems() {
        return purchasedItems;
    }

    public void setPurchasedItems(List<PurchasedItem> purchasedItems) {
        this.purchasedItems = purchasedItems;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}

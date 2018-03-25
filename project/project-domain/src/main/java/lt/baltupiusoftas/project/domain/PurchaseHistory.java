package lt.baltupiusoftas.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PURCHASE_HISTORY")
public class PurchaseHistory implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    @Column(name="STATUS")
    private String status;
    @Column(name = "PURCHASE_DATE")
    private Date purchaseDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

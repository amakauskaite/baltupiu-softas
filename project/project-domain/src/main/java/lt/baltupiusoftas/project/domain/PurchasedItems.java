package lt.baltupiusoftas.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="PURCHASED_ITEMS")
public class PurchasedItems implements Serializable{

    @Column(name="PURCHASE_ID")
    private Long pid;
    @Column(name="ITEM_ID")
    private Long iid;
    @Column(name="AMOUNT")
    private Integer amount;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getIid() {
        return iid;
    }

    public void setIid(Long iid) {
        this.iid = iid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

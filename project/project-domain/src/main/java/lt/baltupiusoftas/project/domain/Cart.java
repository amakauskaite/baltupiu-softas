package lt.baltupiusoftas.project.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CART")
public class Cart implements Serializable{

    @Id
    @GeneratedValue
    private Long id; //????

    @Column(name="USER_ID")
    private Long uid;
    @Column(name="ITEM_ID")
    private Long iid;
    @Column(name = "AMOUNT")
    private Integer amount;


}

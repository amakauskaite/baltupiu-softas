package lt.baltupiusoftas.project.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ITEM")
public class Item implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Cart cart;

    @OneToOne
    private Category category;

    @Column(name="SKU")
    private String SKU;
    @Column(name="NAME")
    private String name;
    @Column(name="PRICE")
    private Integer price;
    @Column(name="SUMMARY")
    private String summary;
    @Column(name="PHOTO")
    private String photo;
/*    @Column
    private String category;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

/*    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }*/
}

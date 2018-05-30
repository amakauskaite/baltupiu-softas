package lt.baltupiusoftas.project.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Product
 *
 * @author Audrius Tvarijonas
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;

    @Column(name = "SKU")
    private String SKU;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "SUMMARY")
    @Type(type="text")
    private String summary;

    @Column(name = "PHOTO")
    @Type(type="text")
    private String photo;

    @Column(name = "LAST_UPDATED")
    private Date lastUpdated;

    public Product() {
    }

    public Product(Category category, String SKU, String name, BigDecimal price, String summary, String photo, Date lastUpdated) {
        this.category = category;
        this.SKU = SKU;
        this.name = name;
        this.price = price;
        this.summary = summary;
        this.photo = photo;
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPhoto() {
        if (photo!=null)return photo;
        else return "https://blog.stylingandroid.com/wp-content/themes/lontano-pro/images/no-image-slide.png";
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}

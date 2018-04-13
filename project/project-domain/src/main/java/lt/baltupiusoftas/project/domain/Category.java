package lt.baltupiusoftas.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Category
 *
 * @author Audrius Tvarijonas
 */
@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * List of all products belonging to this category
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    @Column(name = "NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

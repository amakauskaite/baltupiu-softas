package lt.baltupiusoftas.project.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Category
 *
 * @author Audrius Tvarijonas
 */
@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

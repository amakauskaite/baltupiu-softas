package lt.baltupiusoftas.project.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ADMINISTRATOR")
public class Administrator implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package lt.baltupiusoftas.project.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="LOGGER")
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //username if admin and email if user
    @Column(name="USER_NAME")
    private String user;

    //user = false, admin = true
    @Column (name="IS_ADMIN")
    private Boolean isAdmin;


    @Column (name = "DATE")
    private Date date;

    //class + method
    @Column (name = "ACTION")
    private String action;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}

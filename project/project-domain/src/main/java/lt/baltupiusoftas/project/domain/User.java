package lt.baltupiusoftas.project.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="USER")
public class User implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    @Column(name="EMAIL")
    private String email;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name="LASTNAME")
    private String lastname;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="PHONE_NUMBER")
    private Integer phonenumber;
    @Column(name="IS_BLOCKED")
    private Boolean isBlocked = false;

    @OneToMany
    private UserAddress userAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }
}

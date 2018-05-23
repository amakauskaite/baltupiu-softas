package lt.baltupiusoftas.project.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User Address
 *
 * @author Audrius Tvarijonas
 */
@Entity
@Table(name="USER_ADDRESS")
public class UserAddress implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "HOUSE")
    private String house;

    @Column(name = "FLAT")
    private String flat;

    @Column(name = "POSTCODE")
    private String postcode;

    public UserAddress() {
    }

    public UserAddress(String country, String city, String street, String house, String flat, String postcode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.postcode = postcode;
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}

package lt.baltupiusoftas.project.app.user;

import lt.baltupiusoftas.project.domain.UserAddress;
import lt.baltupiusoftas.project.service.user.address.UserAddressService;

import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@Model
public class UserAddressUpdateBean {
    
    private Long id;

    private String country;
    private String city; 
    private String street; 
    private Integer house; 
    private Integer flat; 
    private Integer postcode;

    private UserAddress userAddress;

    @Inject
    private UserAddressService userAddressService;

    public void updateAddress () {
        userAddress = userAddressService.updateUserAddress(id, country, city, street, house, flat, postcode);
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }
}

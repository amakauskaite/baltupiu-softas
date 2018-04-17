package lt.baltupiusoftas.project.app.user;

import lt.baltupiusoftas.project.domain.UserAddress;
import lt.baltupiusoftas.project.service.user.address.UserAddressService;

import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;

@Named
@SessionScoped
public class UserAddressBean implements Serializable {

    private String country;
    private String city; 
    private String street; 
    private String house;
    private String flat;
    private String postcode;

    private UserAddress userAddress;

    @Inject
    private UserAddressService userAddressService;

    @Transactional(Transactional.TxType.REQUIRED)
    public void updateAddress () {
        userAddress = userAddressService.updateUserAddress(userAddress, country, city, street, house, flat, postcode);
    }


    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
        this.country = userAddress.getCountry();
        this.city = userAddress.getCity();
        this.flat = userAddress.getFlat();
        this.house = userAddress.getHouse();
        this.street = userAddress.getStreet();
        this.postcode = userAddress.getPostcode();
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

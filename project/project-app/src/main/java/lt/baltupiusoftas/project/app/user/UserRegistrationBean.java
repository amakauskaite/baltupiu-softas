package lt.baltupiusoftas.project.app.user;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.password.PasswordHashingService;
import lt.baltupiusoftas.project.service.user.UserService;
import lt.baltupiusoftas.project.service.user.address.UserAddressService;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class UserRegistrationBean {

    @Inject
    private UserService userService;

    @Inject
    private UserAddressService userAddressService;

    @Inject
    private PasswordHashingService passwordHashingService;

    private String country;
    private String city;
    private String street;
    private Integer house;
    private Integer flat;
    private Integer postcode;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private User user;



    public void register() {
        user = userService.register(email, passwordHashingService.hashPassword(password), firstname, lastname, phoneNumber, userAddressService.createUserAddress(country, city, street, house, flat, postcode));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

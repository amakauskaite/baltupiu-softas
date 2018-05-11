package lt.baltupiusoftas.project.app.user;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.PasswordHashingService;
import lt.baltupiusoftas.project.service.UserService;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class UserRegistrationBean{

    @Inject
    private UserService userService;

    @Inject
    private PasswordHashingService passwordHashingService;

    @Inject
    private UserLoginBean userLoginBean;

    private String country;
    private String city;
    private String street;
    private String house;
    private String flat;
    private String postcode;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private User user;


@Transactional(Transactional.TxType.REQUIRED)
    public String register() {
        user = userService.register(email, password, firstname, lastname, phoneNumber);

        if (user == null) {
            FacesContext.getCurrentInstance().addMessage("registrationBtn", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Klaida!",  "Vartotojas jau egzistuoja"));
            return "registration"; //error_register_user_exist

        } else {
            FacesContext.getCurrentInstance().addMessage("registrationBtn", new FacesMessage(FacesMessage.SEVERITY_INFO,"Sėkminga",  "Registracija pavyko"));
            //clearFields();

            //try to login after registration
            if (userLoginBean.login().equals("login")) {
                return "registration";
            }

            return "index"; //success_register_user
        }
    }

    private void clearFields()
    {
        // Sets all registration form fields to null, if the registration was successful
        setFirstname(null);
        setLastname(null);
        setPassword(null);
        setEmail(null);
        setPhoneNumber(null);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        userLoginBean.setEmail(email);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = passwordHashingService.hashPassword(password);
        userLoginBean.setPassword(password);
    }
}

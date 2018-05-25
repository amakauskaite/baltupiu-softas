package lt.baltupiusoftas.project.app.user;

import lt.baltupiusoftas.project.app.Login;
import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.UserAddress;
import lt.baltupiusoftas.project.persistence.UserAddressDao;
import lt.baltupiusoftas.project.service.PasswordHashingService;
import lt.baltupiusoftas.project.service.UserService;
import lt.baltupiusoftas.project.service.UserAddressService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;

@Model
public class UserUpdateBean {


    //USER
    private Long userId;
    private User user;

    //USER ADDRESS
    private String country;
    private String city;
    private String street;
    private String house;
    private String flat;
    private String postcode;

    private UserAddress userAddress;

    //USER PASSWORD
    private String newPassword;
    private String oldPassword;

    //USER INFO
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;


    //INJECTIONS
    @Inject
    private UserAddressService userAddressService;
    @Inject
    private UserService userService;
    @Inject
    private PasswordHashingService passwordHashing;

    @Inject
    private UserAddressDao userAddressDao;

    @Inject
    private Login login;



    @PostConstruct
    //@Transactional(Transactional.TxType.REQUIRED)
    public void init()
    {
        try {
            this.user = login.getUser();
            this.userId = user.getId();
            //TODO: pataisyti, kad imtu is servisu, o ne tiesiai is dao
            this.userAddress = userAddressDao.find(user.getUserAddress());
        }
        catch (NullPointerException npe)
        {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
            }
            catch (IOException ioe)
            {
                System.out.println("Failed to redirect to another page in "+this.getClass().getName());
            }

        }

    }

    @Transactional(Transactional.TxType.REQUIRED)
    public String updatePassword () {
        oldPassword = user.getPassword();
            this.user =  userService.updatePassword(userId, oldPassword, newPassword);
            if (user == null) {
                FacesContext.getCurrentInstance().addMessage("passUpdateBtn", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Klaida!",  "Nepavyko pakeisti slaptažodžio."));
                return "passwordChange";
            }
            login.setUser(user);
        return "passwordChange";
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public String updateAddress () {
        fillAddressFields();
        this.userAddress = userAddressService.updateUserAddress(userAddress, country, city, street, house, flat, postcode);
        if(userAddress == null)
        {
            FacesContext.getCurrentInstance().addMessage("addressUpdateBtn", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Klaida!",  "Nepavyko išsaugoti adreso. Bandykite dar kartą."));
            return "addressChange";
        }
        login.setUser(user);
        return "addressChange";
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public String createAddress () {
        this.userAddress = userAddressService.createUserAddress(country, city, street, house, flat, postcode, userId);
        return "profile";
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public String updateUserInfo () {
        fillUserInfo();
        this.user = userService.updateUserInfo(userId, firstname, lastname, email, phoneNumber);
        if (user == null) {
            FacesContext.getCurrentInstance().addMessage("userUpdateBtn", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Klaida!",  "Nepavyko išsaugoti naujos informacijos. Bandykite dar kartą."));
            return "profile";
        }
        login.setUser(user);
        return "profile";

    }

    private void fillUserInfo()
    {
        firstname = user.getFirstname();
        lastname = user.getLastname();
        email = user.getEmail();
        phoneNumber = user.getPhonenumber();
    }

    private void fillAddressFields()
    {
        country = userAddress.getCountry();
        city = userAddress.getCity();
        street = userAddress.getStreet();
        house = userAddress.getHouse();
        flat = userAddress.getFlat();
        postcode = userAddress.getPostcode();
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = passwordHashing.hashPassword(newPassword);
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = passwordHashing.hashPassword(oldPassword);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
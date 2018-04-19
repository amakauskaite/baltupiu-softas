package lt.baltupiusoftas.project.app;

import lt.baltupiusoftas.project.app.user.UserAddressBean;
import lt.baltupiusoftas.project.app.user.UserLoginBean;
import lt.baltupiusoftas.project.app.user.UserPasswordUpdateBean;
import lt.baltupiusoftas.project.app.user.UserRegistrationBean;
import lt.baltupiusoftas.project.domain.*;
import lt.baltupiusoftas.project.persistence.CartDao;
import lt.baltupiusoftas.project.persistence.CategoryDao;
import lt.baltupiusoftas.project.persistence.ProductDao;
import lt.baltupiusoftas.project.persistence.UserDao;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * The ultimate bean
 *
 * @author Audrius Tvarijonas
 */
@Model
public class UltimateBean {

    @Inject
    private UserLoginBean userLoginBean;


    @Inject
    private UserPasswordUpdateBean userPasswordUpdateBean;

    @Inject
    private UserRegistrationBean userRegistrationBean;

    @Transactional
    public String helloWorld() {

        String result = "";

        //registrate user
        userRegistrationBean.setCity("vilnius");
        userRegistrationBean.setCountry("lithuania");
        userRegistrationBean.setEmail("mail@email.com");
        userRegistrationBean.setFirstname("name");
        userRegistrationBean.setHouse("10");
        userRegistrationBean.setFlat("412q");
        userRegistrationBean.setPassword("secret");
        userRegistrationBean.setPhoneNumber("112");
        userRegistrationBean.setLastname("surname");
        userRegistrationBean.setStreet("street");
        userRegistrationBean.setPostcode("1111");
        userRegistrationBean.register();
        if (userRegistrationBean.getUser() != null) {
            result += "Registered with email " + userRegistrationBean.getEmail();
        } else {
            result +=  "User exist";
        }

        result += "\n";

        userLoginBean.setEmail("mail@email.com");
        userLoginBean.setPassword("secret");
        userLoginBean.login();

        if (userLoginBean.getUser() != null) {
            result += "Login with email " + userLoginBean.getEmail();



        } else {
            result += "Cannot find user to login";
        }

        result += "\n";




        return result;
    }

    public String update () {
        String result = "";
        if (userLoginBean.getUser() != null) {
            userPasswordUpdateBean.setUser(userLoginBean.getUser());
            userPasswordUpdateBean.setNewPassword("secret1");
            userPasswordUpdateBean.setOldPassword("secret");
            userPasswordUpdateBean.updatePassword();

            if (userPasswordUpdateBean.isUpdated()) {
                result += "Password updated";
            } else {
                result += "Password not updated";
            }

            userLoginBean.logout();

            userLoginBean.setEmail("mail@email.com");
            userLoginBean.setPassword("secret1");
            userLoginBean.login();

            if (userLoginBean.getUser() != null) {
                result += "Login with email " + userLoginBean.getEmail();



            } else {
                result += "Cannot find user to login";
            }

            result += "\n";

        }

        return  result;
    }
}

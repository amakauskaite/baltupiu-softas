package lt.baltupiusoftas.project.app;

import lt.baltupiusoftas.project.app.user.UserLoginBean;
import lt.baltupiusoftas.project.app.user.UserRegistrationBean;
import lt.baltupiusoftas.project.app.user.UserUpdateBean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * The ultimate bean
 *
 * @author Audrius Tvarijonas
 */
@Model
public class UltimateBean {

    @Inject
    private Login login;

    @Inject
    private UserLoginBean userLoginBean;


    @Inject
    private UserRegistrationBean userRegistrationBean;

    @Inject
    private UserUpdateBean userUpdateBean;

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
        result += userRegistrationBean.register();
        if (userRegistrationBean.getUser() != null) {
            result += "Registered with email " + userRegistrationBean.getEmail();
        } else {
            result += "User exist";
        }

        result += "\n";

        userLoginBean.setEmail("mail@email.com");
        userLoginBean.setPassword("secret1");
        result += userLoginBean.login();


        if (userLoginBean.getEmail() != null) {
            result += "Login with email " + userLoginBean.getEmail();


        } else {
            result += "Cannot find user to login";
        }
        userUpdateBean.setOldPassword("secret1");
        System.out.println(userUpdateBean.getOldPassword());
        userUpdateBean.setNewPassword("secret");
        userUpdateBean.updatePassword();

        result += "\n";

        return result;
//        return "+";
    }
}

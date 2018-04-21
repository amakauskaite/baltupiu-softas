package lt.baltupiusoftas.project.app;

import lt.baltupiusoftas.project.app.user.UserAddressBean;
import lt.baltupiusoftas.project.app.user.UserLoginBean;
import lt.baltupiusoftas.project.app.user.UserPasswordUpdateBean;
import lt.baltupiusoftas.project.app.user.UserRegistrationBean;

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
    private UserLoginBean userLoginBean;

    @Inject
    private UserAddressBean userAddressBean;


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


        userAddressBean.setCity("vilnius");
        userAddressBean.setCountry("lithuania");
        userAddressBean.setFlat("101");
        userAddressBean.setHouse("10");
        userAddressBean.setPostcode("100001");
        userAddressBean.setStreet("didlaukio g.");
        userAddressBean.createAddress();

        if (userAddressBean.getUserAddress() != null) {
            result += "address added @" + userAddressBean.getCity();
            userAddressBean.setStreet("not didlaukio g.");
            userAddressBean.updateAddress();
            result += " " + userAddressBean.getUserAddress().getStreet();
        } else {
            result += "ADDRESS NOT ADDED";
        }




        return result;
    }


    public String update () {
        System.out.println(userLoginBean.getUser().getPassword());
        String result = "";
        if (userLoginBean.getUser() != null) {
            System.out.println(userLoginBean.getUser().getPassword());
            userPasswordUpdateBean.setUser(userLoginBean.getUser());
            userPasswordUpdateBean.setNewPassword("secret1");
            userPasswordUpdateBean.setOldPassword("secret");
            userPasswordUpdateBean.updatePassword();

            if (userPasswordUpdateBean.isUpdated()) {
                System.out.println(userLoginBean.getUser().getPassword());
                result += "Password updated";
            } else {
                result += "Password not updated";
            }

//            userLoginBean.logout();
//
//            userLoginBean.setEmail("mail@email.com");
//            userLoginBean.setPassword("secret1");
//            userLoginBean.login();
//
//            if (userLoginBean.getUser() != null) {
//                result += "Login with email " + userLoginBean.getEmail();
//
//
//
//            } else {
//                result += "Cannot find user to login";
//            }
//
//            result += "\n";

        }

        return  result;
    }
}

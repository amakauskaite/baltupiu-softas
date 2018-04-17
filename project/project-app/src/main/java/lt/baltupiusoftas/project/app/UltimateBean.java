package lt.baltupiusoftas.project.app;

import lt.baltupiusoftas.project.app.user.UserAddressBean;
import lt.baltupiusoftas.project.app.user.UserLoginBean;
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
//
//    @Inject
//    private UserAddressBean userAddressBean;

    @Inject
    private UserRegistrationBean userRegistrationBean;

    @Transactional
    public String helloWorld() {

        //registraate user
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
            return "Registered with email " + userRegistrationBean.getEmail();
        } else {
            return "User exist";
        }

//        userLoginBean.setEmail("mail@email.com");
//        userLoginBean.setPassword("secret");
//
//        return userLoginBean.getUser().getFirstname();
//        // Create category
//        Category category = new Category("Entirety");
//
//        /* Persist */
//        categoryDao.create(category);
//
//        // Create product
//        Product product = new Product(category, "0000", "Shampoo", new BigDecimal(20), "veri good shampoo", null, null);
//
//        /* Persist */
//        productDao.create(product);
//
//        // Create user
//        User user = new User("i@am", "FistName", "LastName", "qwerty", "666566",
//                new UserAddress("Lithuania", "Vilnius", "Street", "00", "0", "000"));
//        /* Persist */
//        userDao.create(user);
//
//        // Create cart
//        Cart cart = new Cart(user);
//
//        /* Persist */
//        cartDao.create(cart);
//
//        /*
//         * Buy some of that Shampoo
//         */
//        cart.getItems().add(new CartItem(product));
//        cart.getItems().add(new CartItem(product));
//
//        /* Persist */
//        cartDao.update(cart);
//
//        // Harvest
//
//        List<Cart> cartList = cartDao.findUserCarts(user.getId());
//        Cart myCart = cartList.get(0);
//
//        return String.format("I'm trying to buy %s for %f", myCart.getItems().get(0).getProduct().getName(),
//                myCart.getItems().get(0).getProduct().getPrice());
    }
}

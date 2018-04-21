package lt.baltupiusoftas.project.service.user.address;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.UserAddress;

import java.io.Serializable;

public interface UserAddressService extends Serializable {

     UserAddress updateUserAddress (UserAddress userAddress, String country, String city, String street, String house, String flat, String postcode);
     UserAddress createUserAddress (String country, String city, String street, String house, String flat, String postcode, User user);
}

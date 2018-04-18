package lt.baltupiusoftas.project.service.user.address;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.UserAddress;

public interface UserAddressService {

     UserAddress updateUserAddress (UserAddress userAddress, String country, String city, String street, Integer house, Integer flat, Integer postcode);
     UserAddress createUserAddress (String country, String city, String street, Integer house, Integer flat, Integer postcode);
}

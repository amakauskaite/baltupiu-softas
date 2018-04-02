package lt.baltupiusoftas.project.service.user.address;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.UserAddress;

public interface UserAddressService {

     UserAddress updateUserAddress (Long id, String country, String city, String street, int house, int flat, int postcode);
     UserAddress createUserAddress (User user, String country, String city, String street, int house, int flat, int postcode);
}

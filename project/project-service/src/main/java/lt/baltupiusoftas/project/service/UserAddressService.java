package lt.baltupiusoftas.project.service;


import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.UserAddress;

import java.io.Serializable;

public interface UserAddressService extends Serializable {

     UserAddress updateUserAddress (Long userAddressId, String country, String city, String street, String house, String flat, String postcode);
     UserAddress createUserAddress (String country, String city, String street, String house, String flat, String postcode, Long userId);
}
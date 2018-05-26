package lt.baltupiusoftas.project.service.impl;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.UserAddress;
import lt.baltupiusoftas.project.persistence.UserAddressDao;
import lt.baltupiusoftas.project.persistence.UserDao;
import lt.baltupiusoftas.project.service.UserAddressService;

import javax.inject.Inject;

public class UserAddressServiceImpl implements UserAddressService {
    @Inject
    private UserAddressDao userAddressDao;

    @Inject
    private UserDao userDao;
    @Override
    public UserAddress updateUserAddress(Long userAddressId, String country, String city, String street, String house,  String flat, String postcode) {
        UserAddress userAddress = userAddressDao.find(userAddressId);
        userAddress = setValues(userAddress, country, city, street, house, flat, postcode);
        return userAddressDao.update(userAddress);
    }

    @Override
    public UserAddress createUserAddress(String country, String city, String street, String house, String flat, String postcode, Long userId) {
        UserAddress address = new UserAddress();
        address = setValues(address, country, city, street, house, flat, postcode);
        User user = userDao.find(userId);
        user.setUserAddress(address);
        userDao.update(user);
        return userAddressDao.create(address);
    }

    private UserAddress setValues (UserAddress address, String country, String city, String street, String house, String flat, String postcode) {
        address.setCity(city);
        address.setCountry(country);
        address.setFlat(flat);
        address.setHouse(house);
        address.setPostcode(postcode);
        address.setStreet(street);
        return address;
    }
}

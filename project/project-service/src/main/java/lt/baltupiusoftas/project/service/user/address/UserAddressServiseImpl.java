package lt.baltupiusoftas.project.service.user.address;

import lt.baltupiusoftas.project.domain.UserAddress;
import lt.baltupiusoftas.project.persistence.UserAddressDao;

import javax.inject.Inject;

public class UserAddressServiseImpl implements UserAddressService {
    @Inject
    private UserAddressDao userAddressDao;
    @Override
    public UserAddress updateUserAddress(UserAddress userAddress, String country, String city, String street, String house,  String flat, String postcode) {
        userAddress = setValues(userAddress, country, city, street, house, flat, postcode);
        return userAddressDao.update(userAddress);
    }

    @Override
    public UserAddress createUserAddress(String country, String city, String street, String house, String flat, String postcode) {
        UserAddress address = new UserAddress();
        address = setValues(address, country, city, street, house, flat, postcode);
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

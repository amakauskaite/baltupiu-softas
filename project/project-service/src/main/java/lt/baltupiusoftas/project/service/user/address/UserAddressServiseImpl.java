package lt.baltupiusoftas.project.service.user.address;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.UserAddress;
import lt.baltupiusoftas.project.persistence.UserAddressRepository;

import javax.inject.Inject;

public class UserAddressServiseImpl implements UserAddressService {
    @Inject
    private UserAddressRepository addressRepository;
    @Override
    public UserAddress updateUserAddress(UserAddress userAddress, String country, String city, String street, Integer house,  Integer flat, Integer postcode) {
        userAddress = setValues(userAddress, country, city, street, house, flat, postcode);
        return addressRepository.update(userAddress);
    }

    @Override
    public UserAddress createUserAddress(String country, String city, String street, Integer house, Integer flat, Integer postcode) {
        UserAddress address = new UserAddress();
        address = setValues(address, country, city, street, house, flat, postcode);
        return addressRepository.create(address);
    }

    private UserAddress setValues (UserAddress address, String country, String city, String street, Integer house, Integer flat, Integer postcode) {
        address.setCity(city);
        address.setCountry(country);
        address.setFlat(flat);
        address.setHouse(house);
        address.setPostcode(postcode);
        address.setStreet(street);
        return address;
    }
}

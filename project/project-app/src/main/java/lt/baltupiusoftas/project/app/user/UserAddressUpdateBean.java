package lt.baltupiusoftas.project.app.user;

import lt.baltupiusoftas.project.domain.UserAddress;
import lt.baltupiusoftas.project.service.user.address.UserAddressService;

import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@Model
@RequestScoped
public class UserAddressUpdateBean {
    
    private Long id;
    private String country;
    private String city; 
    private String street; 
    private int house; 
    private int flat; 
    private int postcode;

    @Inject
    private UserAddressService userAddressService;

    public UserAddress updateAddress () {
        return userAddressService.updateUserAddress(id, country, city, street, house, flat, postcode);
    }


}

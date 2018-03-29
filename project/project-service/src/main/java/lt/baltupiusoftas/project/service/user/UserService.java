package lt.baltupiusoftas.project.service.user;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.UserAddress;


public interface UserService {
    public User login (String email, String password);
   //TODO add userAddress to registration
    public User register (String email, String password, String firstname, String lastname, Integer phoneNumber);

    //TODO think more about implementation
//    public User updateAddress (Long id,  UserAddress address);
//    public User updatePassword (Long id, String newPassword);
}

package lt.baltupiusoftas.project.service.user;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.UserAddress;

import java.io.Serializable;


public interface UserService extends Serializable {
     User login (String email, String password);
     User register (String email, String password, String firstname, String lastname, String phoneNumber, UserAddress address);
     User updatePassword (Long id, String oldPassword, String newPassword);
}

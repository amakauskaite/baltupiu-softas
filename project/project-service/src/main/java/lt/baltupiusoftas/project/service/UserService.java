package lt.baltupiusoftas.project.service;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.UserAddress;

import java.io.Serializable;


public interface UserService extends Serializable {
     User login (String email, String password);
     User register (String email, String password, String firstname, String lastname, String phoneNumber);
     User updatePassword (Long userId, String oldPassword, String newPassword);
     User updateUserInfo (Long userId, String firstname, String lastname, String email, String phoneNumber);
}
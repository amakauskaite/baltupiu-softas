package lt.baltupiusoftas.project.service;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.UserAddress;

import java.io.Serializable;
import java.util.List;


public interface UserService extends Serializable {

     User login(String email, String password);

     User register(String email, String password, String firstname, String lastname, String phoneNumber);

     User updatePassword(Long userId, String oldPassword, String newPassword);

     User updateUserInfo(Long userId, String firstname, String lastname, String email, String phoneNumber);

     UserAddress findUserAddress(Long userId);

     /**
      * Deletes user from database by user id
      *
      * @param userId id of user to be deleted
      */
     void deleteUser(Long userId);

     /**
      * Creates and persists temporary {@link User} with {@link lt.baltupiusoftas.project.domain.Cart} to be used
      * while guest is not logged in
      *
      * @return user instance
      */
     User initTemporaryUser();

     List<User> getAllUsers();
     User changeBlockStatus(Long userId, boolean status);

}

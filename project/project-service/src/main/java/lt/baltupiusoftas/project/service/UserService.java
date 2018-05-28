package lt.baltupiusoftas.project.service.user;

import lt.baltupiusoftas.project.domain.User;

import java.io.Serializable;


public interface UserService extends Serializable {
    User login(String email, String password);

    User register(String email, String password, String firstname, String lastname, String phoneNumber);

    User updatePassword(User user, String oldPassword, String newPassword);

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
}

package lt.baltupiusoftas.project.service.user;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.UserAddress;
import lt.baltupiusoftas.project.persistence.UserDao;

import javax.inject.Inject;

public class UserServiceImpl implements UserService{
    @Inject
    private UserDao userDao;

    @Override
    public User login(String email, String password) {
        User user = userDao.findByEmail(email);
        if (user != null && user.getPassword().equals(password) ) {
             return user;
        }
        return null;
    }

    @Override
    public User register(String email, String password, String firstname, String lastname, String phoneNumber) {
        User user = userDao.findByEmail(email);
        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setBlocked(false);
            user.setPhonenumber(phoneNumber);
            return userDao.create(user);
        }
        return null;

    }

    @Override
    public User updatePassword(User user,  String oldPassword, String newPassword) {
        if (user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            return userDao.update(user);

        }
        return user;
    }


}

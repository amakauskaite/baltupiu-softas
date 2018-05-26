package lt.baltupiusoftas.project.service.impl;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.UserAddress;
import lt.baltupiusoftas.project.persistence.UserDao;
import lt.baltupiusoftas.project.service.UserService;

import javax.inject.Inject;
import javax.transaction.Transactional;

public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public User login(String email, String password) {
        User user = userDao.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
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
    public User updatePassword(Long userId, String oldPassword, String newPassword) {
        User user = userDao.find(userId);
        if (user != null) {

            if (user.getPassword().equals(oldPassword)) {
                user.setPassword(newPassword);
                return userDao.update(user);

            }

        }
        return null;
    }

    @Override
    public User updateUserInfo(Long userId, String firstname, String lastname, String email, String phoneNumber) {
        User user = userDao.find(userId);
        if (user != null) {
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmail(email);
            user.setPhonenumber(phoneNumber);
            return userDao.update(user);
        }
        return null;
    }

    @Override
    public UserAddress findUserAddress(Long userId) {
        User user = userDao.find(userId);
        return user.getUserAddress();
    }


}
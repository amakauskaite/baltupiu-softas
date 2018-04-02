package lt.baltupiusoftas.project.service.user;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.domain.UserAddress;
import lt.baltupiusoftas.project.persistence.UserRepository;

import javax.inject.Inject;

public class UserServiceImpl implements UserService{
    @Inject
    private UserRepository userRepository;

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password) ) {
             return user;
        }
        //TODO maybe error?
        return null;
    }

    @Override
    public User register(String email, String password, String firstname, String lastname, Integer phoneNumber, UserAddress address) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setBlocked(false);
        user.setPhonenumber(phoneNumber);
        user.setUserAddress(address);
        return userRepository.create(user);
    }

    @Override
    public User updatePassword(Long id, String oldPassword, String newPassword) {
        if (oldPassword.equals(newPassword)) {
            User user = userRepository.find(id);
            user.setPassword(newPassword);
            return userRepository.update(user);

        }
        //TODO error?
        return null;
    }


}

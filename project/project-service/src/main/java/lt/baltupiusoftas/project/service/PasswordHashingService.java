package lt.baltupiusoftas.project.service;

import java.io.Serializable;

public interface PasswordHashingService extends Serializable {
    String hashPassword  (String password);
}

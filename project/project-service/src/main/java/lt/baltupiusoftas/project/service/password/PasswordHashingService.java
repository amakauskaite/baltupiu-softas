package lt.baltupiusoftas.project.service.password;

import java.io.Serializable;

public interface PasswordHashingService extends Serializable {
    String hashPassword  (String password);
}

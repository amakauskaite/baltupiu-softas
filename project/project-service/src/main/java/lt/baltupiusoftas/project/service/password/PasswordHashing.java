package lt.baltupiusoftas.project.service.password;

import java.io.Serializable;

public interface PasswordHashing extends Serializable {
    String hashPassword  (String password);
}

package lt.baltupiusoftas.project.service;

import javax.interceptor.InvocationContext;
import java.util.concurrent.Callable;

public interface LoggerService {




    Object executeTransaction(final Callable<Object> task, InvocationContext context) throws Exception;

     void setUserAndIsAdmin(String user, boolean isAdmin);
}

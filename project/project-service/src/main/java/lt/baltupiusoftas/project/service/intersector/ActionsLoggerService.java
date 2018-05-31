package lt.baltupiusoftas.project.service.intersector;

import javax.interceptor.InvocationContext;


public interface ActionsLoggerService {
    Object logMethodInvocation(InvocationContext context) throws Exception;
}

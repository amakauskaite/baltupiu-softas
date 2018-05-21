package lt.baltupiusoftas.project.service.impl;

import com.sun.org.apache.xml.internal.utils.SystemIDResolver;
import lt.baltupiusoftas.project.domain.Logger;
import lt.baltupiusoftas.project.persistence.LoggerDao;
import lt.baltupiusoftas.project.service.LoggerService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.interceptor.InvocationContext;
import java.util.Date;
import java.util.concurrent.Callable;

import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;

@Stateless
public class LoggerServiceImpl implements LoggerService {

    @Inject
    private LoggerDao loggerDao;


    private static String user;

    private static boolean admin;

    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public Object executeTransaction(Callable<Object> task, InvocationContext context) throws Exception {
                Logger logger = new Logger();
        logger.setDate(new Date());
        logger.setUser(user);
        logger.setAdmin(admin);
        logger.setAction(context.getMethod().getDeclaringClass() + "." + context.getMethod().getName());
        loggerDao.create(logger);
        return task.call();


    }

    public void setUserAndIsAdmin (String user, boolean isAdmin) {
        LoggerServiceImpl.user = user;
        admin = isAdmin;
    }
}

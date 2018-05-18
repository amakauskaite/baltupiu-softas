package lt.baltupiusoftas.project.service.intersector;

import lt.baltupiusoftas.project.domain.Logger;
import lt.baltupiusoftas.project.persistence.LoggerDao;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Transactional;
import java.util.Date;

@Interceptor
@LoggedInvocation
public class ActionsLoggerServiceImpl implements ActionsLoggerService {

    @Inject
    private LoggerDao loggerDao;


    @Override
    @AroundInvoke
    @Transactional(Transactional.TxType.REQUIRED)
    public Object logMethodInvocation(InvocationContext context) throws Exception {
        Logger logger = new Logger();
        logger.setDate(new Date());
        System.out.println(context.getParameters().toString());
        logger.setAction(context.getClass().getName() + "." + context.getMethod().getName());
        loggerDao.create(logger);
        return context.proceed();
    }
}

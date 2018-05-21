package lt.baltupiusoftas.project.service.intersector;

import lt.baltupiusoftas.project.service.LoggerService;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@LoggedInvocation
public class ActionsLoggerServiceImpl implements ActionsLoggerService, Serializable {

    @EJB
    private LoggerService loggerService;

    @Override
    @AroundInvoke
    public Object logMethodInvocation(InvocationContext context) throws Exception {
        Object proceed = null;
        try {
            proceed = loggerService.executeTransaction(()->context.proceed(), context);
            //If you reach here, you will be guaranteed of commit and then you can do the elastic search update
            return proceed;
        } catch (Exception e) {
            //If this happens, and you propagate it, then for sure the transaction will be rolledback, and never get committed. Since all db calls were being done within this transaction, then no DB commit will be done.
            throw e;
        }

    }
}
package my.compary.restaurant.infra;

import my.compary.restaurant.Items;
import one.microstream.storage.types.StorageManager;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@UpdateRoot
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
class UpdateRootInterceptor {

    private static final Logger LOGGER = Logger.getLogger(UpdateRootInterceptor.class.getName());

    @Inject
    private StorageManager manager;

    @AroundInvoke
    public Object auditMethod(InvocationContext ctx) throws Exception {

        Object result = ctx.proceed();
        long storeRoot = manager.storeRoot();
        String message = String.format("Saving the state of root at %s in the method %s, storeRoot id %d",
                ctx.getTarget().getClass(), ctx.getMethod().getName(), storeRoot);

        LOGGER.info(message);
        return result;
    }
}

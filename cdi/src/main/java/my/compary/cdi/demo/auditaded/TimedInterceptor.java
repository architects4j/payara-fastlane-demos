package my.compary.cdi.demo.auditaded;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Timed
@Interceptor
public class TimedInterceptor {

    @AroundInvoke
    public Object auditMethod(InvocationContext ctx) throws Exception {
        calledBefore = true;
        Object result = ctx.proceed();
        calledAfter = true;
        return result;
    }
}

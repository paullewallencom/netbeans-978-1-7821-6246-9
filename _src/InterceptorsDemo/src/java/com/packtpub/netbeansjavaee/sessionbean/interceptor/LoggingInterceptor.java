package com.packtpub.netbeansjavaee.sessionbean.interceptor;

import java.lang.reflect.Method;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author heffel
 */
public class LoggingInterceptor {

    @AroundInvoke
    public Object logMethodCall(InvocationContext invocationContext) throws Exception {
        Object interceptedObject = invocationContext.getTarget();
        Method interceptedMethod = invocationContext.getMethod();

        System.out.println("Entering "
                + interceptedObject.getClass().getName() + "."
                + interceptedMethod.getName() + "()");

        Object o = invocationContext.proceed();

        System.out.println("Leaving  "
                + interceptedObject.getClass().getName() + "."
                + interceptedMethod.getName() + "()");

        return o;
    }
}

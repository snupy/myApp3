package ru.malik.myApp3.server.repos.simple;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

/**
 * Created by Малик on 04.11.2014.
 */
public class FinderIntroductionInterceptor implements IntroductionInterceptor {
    @Override
    public boolean implementsInterface(Class<?> aClass) {
        return aClass.isInterface() && FinderExecutor.class.isAssignableFrom(aClass);
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        FinderExecutor genericDao = (FinderExecutor) methodInvocation.getThis();

        String methodName = methodInvocation.getMethod().getName();
        if (methodName.startsWith("find")) {
            Object[] arguments = methodInvocation.getArguments();
            return genericDao.executeFinder(methodInvocation.getMethod(), arguments);
        } else {
            return methodInvocation.proceed();
        }
    }
}

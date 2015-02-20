package ru.malik.myApp3.server.repos.simple;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Малик on 04.11.2014.
 */
public interface FinderExecutor<T> {
    List<T> executeFinder(Method method, Object[] queryArgs);


}

package ru.malik.myApp3.server.services;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import ru.malik.myApp3.server.business.types.Supplier;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Малик on 09.11.2014.
 */
public class SupplierServiceLocator implements ServiceLocator{

    @Override
    public Object getInstance(Class<?> clazz) {
        HttpServletRequest request = RequestFactoryServlet.getThreadLocalRequest();
        ServletContext servletContext = request.getSession().getServletContext();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        return context.getBean( clazz );

    }
}

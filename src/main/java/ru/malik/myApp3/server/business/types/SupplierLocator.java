package ru.malik.myApp3.server.business.types;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import ru.malik.myApp3.server.business.types.Supplier;
import ru.malik.myApp3.server.services.SupplierService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Малик on 09.11.2014.
 */
public class SupplierLocator extends Locator<Supplier, Long> {
    private SupplierService supplierService;

    @Override
    public Supplier create(Class<? extends Supplier> clazz) {
        return new Supplier();
    }

    @Override
    public Supplier find(Class<? extends Supplier> clazz, Long id) {
        return getSupplierService().findById(id);
    }

    @Override
    public Class<Supplier> getDomainType() {
        return Supplier.class;
    }

    @Override
    public Long getId(Supplier domainObject) {
        return domainObject.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(Supplier domainObject) {
        return domainObject.getVersion();
    }

    private SupplierService getSupplierService() {
        if(supplierService==null) {
            HttpServletRequest request = RequestFactoryServlet.getThreadLocalRequest();
            ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
            supplierService = context.getBean(SupplierService.class);
        }
        return supplierService;
    }
}

package ru.malik.myApp3.client.request.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;
import ru.malik.myApp3.server.business.types.Supplier;
import ru.malik.myApp3.server.business.types.SupplierLocator;

/**
 * Created by Малик on 09.11.2014.
 */

@ProxyFor(value = Supplier.class, locator =  SupplierLocator.class)
public interface  SupplierProxy extends EntityProxy, ValueProxy {
    public String getName();

    public void setName(String name);

    public Long getId();

    public void setId(Long id);
}

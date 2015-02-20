package ru.malik.myApp3.client.request.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import ru.malik.myApp3.server.business.types.BuildingProject;
import ru.malik.myApp3.server.business.types.BuildingProjectLocator;

/**
 * Created by Зуфар on 23.12.2014.
 */

@ProxyFor(value = BuildingProject.class, locator =  BuildingProjectLocator.class)
public interface BuildingProjectProxy extends EntityProxy {
    public String getName();
    public void setName(String name);
    public Long getId();
    public void setId(Long id);
    public Long getVersion();
    public void setVersion(Long version);
}

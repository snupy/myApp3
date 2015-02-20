package ru.malik.myApp3.client.request.proxy;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import ru.malik.myApp3.server.services.utils.BuildingProjectPagingLoadResultBean;

import java.util.List;

/**
 * Created by Зуфар on 23.12.2014.
 */
@ProxyFor(BuildingProjectPagingLoadResultBean.class)
public interface BuildingProjectPagingLoadResultProxy extends ValueProxy, PagingLoadResult<BuildingProjectProxy> {
    @Override
    public List<BuildingProjectProxy> getData();
}

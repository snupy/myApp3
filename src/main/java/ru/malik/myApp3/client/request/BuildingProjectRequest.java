package ru.malik.myApp3.client.request;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.sencha.gxt.data.shared.SortInfo;
import com.sencha.gxt.data.shared.loader.FilterConfig;
import ru.malik.myApp3.client.request.proxy.BuildingProjectPagingLoadResultProxy;
import ru.malik.myApp3.client.request.proxy.BuildingProjectProxy;
import ru.malik.myApp3.server.services.BuildingProjectService;
import ru.malik.myApp3.server.services.BuildingProjectServiceLocator;

import java.util.List;

/**
 * Created by Зуфар on 23.12.2014.
 */
@Service(value = BuildingProjectService.class, locator = BuildingProjectServiceLocator.class)
public interface BuildingProjectRequest extends RequestContext {
    public Request<BuildingProjectPagingLoadResultProxy> getPagingList(int offset, int limit, List<? extends SortInfo> sortInfo, List<? extends FilterConfig> filterConfig);

    public Request<Void> saveOrUpdate(BuildingProjectProxy obj);
}

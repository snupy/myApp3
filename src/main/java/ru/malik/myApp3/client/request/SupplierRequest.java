package ru.malik.myApp3.client.request;

import com.google.web.bindery.requestfactory.shared.*;
import com.sencha.gxt.data.shared.SortInfo;
import com.sencha.gxt.data.shared.loader.FilterConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;
import ru.malik.myApp3.server.services.SupplierService;
import ru.malik.myApp3.server.services.SupplierServiceLocator;
import ru.malik.myApp3.server.services.utils.SuppliersPagingLoadResultBean;

import java.util.List;

/**
 * Created by Малик on 09.11.2014.
 */
@Service(value = SupplierService.class, locator = SupplierServiceLocator.class)
public interface SupplierRequest extends RequestContext{
    @ProxyFor(SuppliersPagingLoadResultBean.class)
    public interface SuppliersPagingLoadResultProxy extends ValueProxy, PagingLoadResult<SupplierProxy>{
        @Override
        public List<SupplierProxy> getData();
    }


    Request<Void> save(SupplierProxy supplier);
    Request<Void> update(SupplierProxy supplier);
    Request<Void> saveOrUpdate(SupplierProxy supplier);
    Request<Void> delete(SupplierProxy supplier);
    Request<Void> deleteAll(List<SupplierProxy> list);
    Request<SupplierProxy> findById(Long id);

    Request<List<SupplierProxy>> getAll();
    Request<SuppliersPagingLoadResultProxy> getPagingSuppliersList(int offset, int limit, List<? extends SortInfo> sortInfo, List<? extends FilterConfig> filterConfig);
}

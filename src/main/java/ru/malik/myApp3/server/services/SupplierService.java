package ru.malik.myApp3.server.services;

import com.sencha.gxt.data.shared.SortInfoBean;
import com.sencha.gxt.data.shared.loader.FilterConfigBean;
import ru.malik.myApp3.client.request.SupplierRequest;
import ru.malik.myApp3.server.business.types.Supplier;
import ru.malik.myApp3.server.services.utils.SuppliersPagingLoadResultBean;

import java.util.List;

/**
 * Created by Малик on 09.11.2014.
 */

public interface SupplierService {
    public void save(Supplier supplier);
    public void update(Supplier supplier);
    public void saveOrUpdate(Supplier supplier);
    public List<Supplier> getAll();
    public Supplier findById(Long id);
    public void delete(Supplier supplier);
    public void deleteAll(List<Supplier> list);
    //public ru.malik.myApp3.client.request.SupplierRequest.SuppliersPagingLoadResultBean getPagingSuppliersList(intintjava.util.List<com.sencha.gxt.data.shared.SortInfoBean>java.util.List<com.sencha.gxt.data.shared.loader.FilterConfigBean>)
    public SuppliersPagingLoadResultBean getPagingSuppliersList(int offset, int limit, List<? extends SortInfoBean> sortInfo, List<? extends FilterConfigBean> filterConfig);
}

package ru.malik.myApp3.server.services;

import com.sencha.gxt.data.shared.SortInfoBean;
import com.sencha.gxt.data.shared.loader.FilterConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.malik.myApp3.server.business.types.Supplier;
import ru.malik.myApp3.server.repos.simple.SupplierDao;
import ru.malik.myApp3.server.services.utils.SuppliersPagingLoadResultBean;

import java.util.List;

/**
 * Created by Малик on 09.11.2014.
 */
@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierDao supplierDao;

    @Override
    public void save(Supplier supplier) {
        supplierDao.create(supplier);
    }


    @Override
    public void update(Supplier supplier) {
        supplierDao.update(supplier);
    }

    @Override
    public void saveOrUpdate(Supplier supplier) {
        supplierDao.saveOrUpdate(supplier);
    }

    @Override
    public List<Supplier> getAll() {
        return supplierDao.getAll();
    }

    @Override
    public Supplier findById(Long id) {
        return supplierDao.read(id);
    }

    @Override
    public void delete(Supplier supplier) {
        supplierDao.delete(supplier);
    }

    @Override
    public void deleteAll(List<Supplier> list) {
        for (Supplier supplier:list){
            delete(supplier);
        }
    }

    @Override
    public SuppliersPagingLoadResultBean getPagingSuppliersList(int offset, int limit, List<? extends SortInfoBean> sortInfo, List<? extends FilterConfigBean> filterConfig){
        List<Supplier> list = supplierDao.getAll(offset, limit, sortInfo, filterConfig);
        int count = supplierDao.count().intValue();

        SuppliersPagingLoadResultBean resultBean = new SuppliersPagingLoadResultBean(list,count, offset);
        return resultBean;
    }
}

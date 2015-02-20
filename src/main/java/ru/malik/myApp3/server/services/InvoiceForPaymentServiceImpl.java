package ru.malik.myApp3.server.services;

import com.sencha.gxt.data.shared.SortInfoBean;
import com.sencha.gxt.data.shared.loader.FilterConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.malik.myApp3.server.business.types.InvoiceForPayment;
import ru.malik.myApp3.server.repos.simple.InvoiceForPaymentDao;
import ru.malik.myApp3.server.services.utils.InvoiceForPaymentsPagingLoadResultBean;

import java.util.List;

/**
 * Created by Малик on 14.12.2014.
 */
@Service
@Transactional
public class InvoiceForPaymentServiceImpl implements InvoiceForPaymentService {
    @Autowired
    InvoiceForPaymentDao invoiceForPaymentDao;

    @Override
    public void save(InvoiceForPayment invoiceForPayment) {
        invoiceForPaymentDao.create(invoiceForPayment);
    }

    @Override
    public void update(InvoiceForPayment invoiceForPayment) {
        invoiceForPaymentDao.update(invoiceForPayment);
    }

    @Override
    public void saveOrUpdate(InvoiceForPayment invoiceForPayment) {
        invoiceForPaymentDao.saveOrUpdate(invoiceForPayment);
    }

    @Override
    public List<InvoiceForPayment> getAll() {
        return invoiceForPaymentDao.getAll();
    }

    @Override
    public InvoiceForPayment findById(Long id) {
        return invoiceForPaymentDao.read(id);
    }

    @Override
    public void delete(InvoiceForPayment invoiceForPayment) {
        invoiceForPaymentDao.delete(invoiceForPayment);
    }

    @Override
    public void deleteAll(List<InvoiceForPayment> list) {
        for (InvoiceForPayment invoiceForPayment : list) {
            delete(invoiceForPayment);
        }
    }

    @Override
    public InvoiceForPaymentsPagingLoadResultBean getPagingSuppliersList(int offset, int limit, List<? extends SortInfoBean> sortInfo, List<? extends FilterConfigBean> filterConfig){
        List<InvoiceForPayment> list = invoiceForPaymentDao.getAll(offset, limit, sortInfo, filterConfig);
        int count = invoiceForPaymentDao.count().intValue();

        InvoiceForPaymentsPagingLoadResultBean resultBean = new InvoiceForPaymentsPagingLoadResultBean(list,count, offset);
        return resultBean;
    }
}

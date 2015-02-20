package ru.malik.myApp3.server.services;

import com.sencha.gxt.data.shared.SortInfoBean;
import com.sencha.gxt.data.shared.loader.FilterConfigBean;
import ru.malik.myApp3.server.business.types.InvoiceForPayment;
import ru.malik.myApp3.server.services.utils.InvoiceForPaymentsPagingLoadResultBean;

import java.util.List;

/**
 * Created by Малик on 14.12.2014.
 */
public interface InvoiceForPaymentService {
    public void save(InvoiceForPayment invoiceForPayment);
    public void update(InvoiceForPayment invoiceForPayment);
    public void saveOrUpdate(InvoiceForPayment invoiceForPayment);
    public List<InvoiceForPayment> getAll();
    public InvoiceForPayment findById(Long id);
    public void delete(InvoiceForPayment invoiceForPayment);
    public void deleteAll(List<InvoiceForPayment> list);
    public InvoiceForPaymentsPagingLoadResultBean getPagingSuppliersList(int offset, int limit, List<? extends SortInfoBean> sortInfo, List<? extends FilterConfigBean> filterConfig);
}

package ru.malik.myApp3.client.request;

import com.google.web.bindery.requestfactory.shared.*;
import com.sencha.gxt.data.shared.SortInfo;
import com.sencha.gxt.data.shared.loader.FilterConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import ru.malik.myApp3.client.request.proxy.InvoiceForPaymentProxy;
import ru.malik.myApp3.server.services.InvoiceForPaymentService;
import ru.malik.myApp3.server.services.InvoiceForPaymentServiceLocator;
import ru.malik.myApp3.server.services.utils.InvoiceForPaymentsPagingLoadResultBean;

import java.util.List;

/**
 * Created by Малик on 14.12.2014.
 */
@Service(value = InvoiceForPaymentService.class, locator = InvoiceForPaymentServiceLocator.class)
public interface InvoiceForPaymentRequest extends RequestContext {
    @ProxyFor(InvoiceForPaymentsPagingLoadResultBean.class)
    public interface InvoiceForPaymentsPagingLoadResultProxy extends ValueProxy, PagingLoadResult<InvoiceForPaymentProxy> {
        @Override
        public List<InvoiceForPaymentProxy> getData();
    }
    Request<Void> save(InvoiceForPaymentProxy supplier);
    Request<Void> update(InvoiceForPaymentProxy supplier);
    Request<Void> saveOrUpdate(InvoiceForPaymentProxy supplier);
    Request<Void> delete(InvoiceForPaymentProxy supplier);
    Request<Void> deleteAll(List<InvoiceForPaymentProxy> list);
    Request<InvoiceForPaymentProxy> findById(Long id);

    Request<List<InvoiceForPaymentProxy>> getAll();
    Request<InvoiceForPaymentsPagingLoadResultProxy> getPagingSuppliersList(int offset, int limit, List<? extends SortInfo> sortInfo, List<? extends FilterConfig> filterConfig);
}

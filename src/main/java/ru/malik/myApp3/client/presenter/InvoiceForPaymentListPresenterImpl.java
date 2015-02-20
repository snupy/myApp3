package ru.malik.myApp3.client.presenter;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.sencha.gxt.data.shared.SortInfo;
import com.sencha.gxt.data.shared.loader.*;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.request.InvoiceForPaymentRequest;
import ru.malik.myApp3.client.request.proxy.InvoiceForPaymentProxy;
import ru.malik.myApp3.client.view.InvoiceForPaymentListView;
import ru.malik.myApp3.client.view.InvoiceForPaymentListViewImpl;


import java.util.List;

/**
 * Created by Малик on 15.12.2014.
 */
public class InvoiceForPaymentListPresenterImpl extends AbstractListViewPresenter<InvoiceForPaymentListView, InvoiceForPaymentProxy> implements InvoiceForPaymentListPresenter {

    ClientFactory clientFactory;

    InvoiceForPaymentListView view;

    @Override
    public void addItem() {
        InvoiceForPaymentEditDialogPresenterImpl invoceForPaymentEditDialogPresenter = new InvoiceForPaymentEditDialogPresenterImpl(clientFactory);
        InvoiceForPaymentRequest request = clientFactory.getRequestFactory().invoiceForPaymentRequest();
        invoceForPaymentEditDialogPresenter.edit(request.create(InvoiceForPaymentProxy.class), request);
        invoceForPaymentEditDialogPresenter.show();
    }

    @Override
    public void deleteItem(List<InvoiceForPaymentProxy> list) {

    }

    @Override
    public void editItem(InvoiceForPaymentProxy supplierProxy) {
        InvoiceForPaymentEditDialogPresenterImpl invoceForPaymentEditDialogPresenter = new InvoiceForPaymentEditDialogPresenterImpl(clientFactory);
        InvoiceForPaymentRequest request = clientFactory.getRequestFactory().invoiceForPaymentRequest();
        invoceForPaymentEditDialogPresenter.edit(request.edit(supplierProxy), request);
        invoceForPaymentEditDialogPresenter.show();
    }

    public InvoiceForPaymentListPresenterImpl(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        view = new InvoiceForPaymentListViewImpl();
        view.setPresenter(this);
        bindModel();
    }


    public void bindModel() {
        RequestFactoryProxy<FilterPagingLoadConfig, PagingLoadResult<InvoiceForPaymentProxy>> proxy = new RequestFactoryProxy<FilterPagingLoadConfig, PagingLoadResult<InvoiceForPaymentProxy>>() {
            @Override
            public void load(FilterPagingLoadConfig loadConfig, Receiver<? super PagingLoadResult<InvoiceForPaymentProxy>> receiver) {
                InvoiceForPaymentRequest request = clientFactory.getRequestFactory().invoiceForPaymentRequest();
                List<SortInfo> sortInfos = createRequestSortInfo(request, loadConfig.getSortInfo());
                List<FilterConfig> filterConfigs = createRequestFilterConfig(request, loadConfig.getFilters());
                request.getPagingSuppliersList(loadConfig.getOffset(), loadConfig.getLimit(), sortInfos, filterConfigs).with("data.supplier").to(receiver);
                request.fire();
            }
        };

        final PagingLoader<FilterPagingLoadConfig, PagingLoadResult<InvoiceForPaymentProxy>> loader = new PagingLoader<FilterPagingLoadConfig, PagingLoadResult<InvoiceForPaymentProxy>>(proxy) {
            @Override
            protected FilterPagingLoadConfig newLoadConfig() {
                return new FilterPagingLoadConfigBean();
            }
        };

        view.setListLoader(loader);
    }

    public InvoiceForPaymentListView getView() {
        return view;
    }

    @Override
    public void selectItem(InvoiceForPaymentProxy obj) {
        //TODO нужно мето
    }

    @Override
    public ClientFactory getClientFactory() {
        return null;
    }
}

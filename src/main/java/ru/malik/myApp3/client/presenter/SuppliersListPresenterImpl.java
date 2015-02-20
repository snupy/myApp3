package ru.malik.myApp3.client.presenter;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.sencha.gxt.data.shared.SortInfo;
import com.sencha.gxt.data.shared.loader.*;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.request.BuildingProjectRequest;
import ru.malik.myApp3.client.request.SupplierRequest;
import ru.malik.myApp3.client.request.proxy.BuildingProjectProxy;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;
import ru.malik.myApp3.client.view.SuppliersListView;
import ru.malik.myApp3.client.view.dialogs.SupplierEditDialog;

import java.util.List;

/**
 * Created by Малик on 09.11.2014.
 */
public class SuppliersListPresenterImpl extends AbstractListViewPresenter<SuppliersListView, SupplierProxy> implements SuppliersListPresenter {

    ClientFactory clientFactory;
    SuppliersListView view;

    public SuppliersListView getView() {
        return view;
    }


    public SuppliersListPresenterImpl(ClientFactory clientFactory) {

        this.clientFactory = clientFactory;
        view = clientFactory.getViewFactory().getSuppliersListView();
        view.setPresenter(this);
        bindModel();
    }

    public void bindModel() {
        RequestFactoryProxy<FilterPagingLoadConfig, PagingLoadResult<SupplierProxy>> proxy = new RequestFactoryProxy<FilterPagingLoadConfig, PagingLoadResult<SupplierProxy>>() {
            @Override
            public void load(FilterPagingLoadConfig loadConfig, Receiver<? super PagingLoadResult<SupplierProxy>> receiver) {
                SupplierRequest request = clientFactory.getRequestFactory().supplierRequest();
                List<SortInfo> sortInfos = createRequestSortInfo(request, loadConfig.getSortInfo());
                List<FilterConfig> filterConfigs = createRequestFilterConfig(request, loadConfig.getFilters());
                request.getPagingSuppliersList(loadConfig.getOffset(), loadConfig.getLimit(), sortInfos, filterConfigs).to(receiver);
                request.fire();
            }
        };

        final PagingLoader<FilterPagingLoadConfig, PagingLoadResult<SupplierProxy>> loader = new PagingLoader<FilterPagingLoadConfig, PagingLoadResult<SupplierProxy>>(proxy) {
            @Override
            protected FilterPagingLoadConfig newLoadConfig() {
                return new FilterPagingLoadConfigBean();
            }
        };

        view.setListLoader(loader);

    }

    @Override
    public void addItem() {
        SupplierEditDialogPresenter supplierEditDialogPresenter = new SupplierEditDialogPresenterImpl(clientFactory);
        SupplierRequest supplierRequest = clientFactory.getRequestFactory().supplierRequest();
        supplierEditDialogPresenter.edit(supplierRequest.create(SupplierProxy.class), supplierRequest);
        supplierEditDialogPresenter.show();

        BuildingProjectRequest request = clientFactory.getRequestFactory().buildingProjectRequest();
        BuildingProjectProxy projectProxy = request.create(BuildingProjectProxy.class);
        projectProxy.setName("ddddd");
        request.saveOrUpdate(projectProxy).fire();
    }

    @Override
    public void deleteItem(List<SupplierProxy> list) {
        SupplierRequest request = clientFactory.getRequestFactory().supplierRequest();
        request.deleteAll(list);
        request.fire();
    }

    @Override
    public void editItem(SupplierProxy supplierProxy) {

        SupplierEditDialogPresenter supplierEditDialogPresenter = new SupplierEditDialogPresenterImpl(clientFactory);
        SupplierRequest supplierRequest = clientFactory.getRequestFactory().supplierRequest();
        supplierEditDialogPresenter.edit(supplierProxy, supplierRequest);
        supplierEditDialogPresenter.show();

    }

    @Override
    public void selectItem(SupplierProxy supplierProxy) {
        super.selectItem(supplierProxy);
        SelectionEvent.<SupplierProxy>fire(this, supplierProxy);
    }

    @Override
    public HandlerRegistration addSelectionHandler(SelectionHandler<SupplierProxy> handler) {
        return clientFactory.getEventBus().addHandler(SelectionEvent.getType(), handler);
    }

    @Override
    public void fireEvent(GwtEvent<?> gwtEvent) {
        clientFactory.getEventBus().fireEvent(gwtEvent);
    }

    @Override
    public ClientFactory getClientFactory() {
        return clientFactory;
    }

}

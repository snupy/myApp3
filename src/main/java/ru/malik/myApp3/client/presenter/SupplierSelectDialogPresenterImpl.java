package ru.malik.myApp3.client.presenter;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.event.OkEvent;
import ru.malik.myApp3.client.event.SelectEvent;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;
import ru.malik.myApp3.client.view.SuppliersListView;
import ru.malik.myApp3.client.view.dialogs.SupplierSelectDialog;

/**
 * Created by Зуфар on 20.12.2014.
 */
public class SupplierSelectDialogPresenterImpl extends AbstractPresenter<SupplierSelectDialog> implements SupplierSelectDialogPresenter {

    private SuppliersListPresenter suppliersListPresenter;

    public SupplierSelectDialogPresenterImpl(ClientFactory clientFactory) {
        super(clientFactory);

        view = getClientFactory().getViewFactory().getDialogFactory().getSupplierSelectDialog();
        view.setPresenter(this);

        suppliersListPresenter = new SuppliersListPresenterImpl(getClientFactory());
        suppliersListPresenter.addSelectionHandler(new SelectionHandler<SupplierProxy>() {
            @Override
            public void onSelection(SelectionEvent<SupplierProxy> event) {

            }
        });
        bindModel();
    }

    @Override
    public void show() {
        getView().show();
    }

    @Override
    public void hide() {
        getView().hide();
    }

    public void bindModel() {
        view.setContent(suppliersListPresenter.getView());
    }

    @Override
    public void select() {
        getClientFactory().getEventBus().fireEvent(new SelectEvent<SupplierProxy>(suppliersListPresenter.getSelectItem()));
    }

    @Override
    public HandlerRegistration addSelectHandlers(SelectEvent.SelectHandler selectHandler) {
        return getClientFactory().getEventBus().addHandler(SelectEvent.TYPE, selectHandler);
    }

    /*ClientFactory clientFactory;
    SupplierSelectDialog view;
    SuppliersListPresenterImpl suppliersListPresenter;
    SupplierProxy supplierProxy;

    @Override
    public void show() {
        view.show();
    }

    @Override
    public void bindModel() {
        view.setContent(suppliersListPresenter.getView());
    }

    public SupplierSelectDialogPresenterImpl(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;

        suppliersListPresenter = new SuppliersListPresenterImpl(clientFactory);
        suppliersListPresenter.addSelectionHandler(new SelectionHandler<SupplierProxy>() {
            @Override
            public void onSelection(SelectionEvent<SupplierProxy> event) {
                SupplierSelectDialogPresenterImpl.this.supplierProxy = event.getSelectedItem();
            }
        });

        this.view = this.clientFactory.getViewFactory().getDialogFactory().getSupplierSelectDialog();
        this.view.setPresenter(this);

        bindModel();
    }

    @Override
    public SupplierProxy getSupplier() {
        return supplierProxy;
    }

    @Override
    public HandlerRegistration addOkHandlers(OkEvent.OkHandler okHandler) {
        return clientFactory.getEventBus().addHandler(OkEvent.TYPE, okHandler);
    }

    @Override
    public void ok() {
        clientFactory.getEventBus().fireEvent(new OkEvent());
    }*/
}

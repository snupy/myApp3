package ru.malik.myApp3.client.presenter;

import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.request.SupplierRequest;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;
import ru.malik.myApp3.client.view.dialogs.SupplierEditDialog;
import ru.malik.myApp3.client.view.SupplierView;

/**
 * Created by Малик on 30.11.2014.
 */
public class SupplierEditDialogPresenterImpl implements SupplierEditDialogPresenter {

    ClientFactory clientFactory;

    SupplierEditDialog view;

    SupplierViewPresenter supplierViewPresenter;

    @Override
    public void edit(SupplierProxy supplier, SupplierRequest editRequest) {
        supplierViewPresenter.edit(supplier, editRequest);
    }


/*    @Override
    public void setSupplierViewPresenter(SupplierViewPresenter presenter) {
        supplierViewPresenter = presenter;
    }*/

    @Override
    public void save() {
        supplierViewPresenter.save();
    }

/*    @Override
    public void cancel() {

    }*/

    public void show() {
        view.show();
    }

    @Override
    public void hide() {
        view.hide();
    }

//    @Override
    public void bindModel() {
        view.setContent(supplierViewPresenter.getView());
    }

    public SupplierEditDialogPresenterImpl(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        view = clientFactory.getViewFactory().getDialogFactory().getSupplierEditDialog();
        view.setPresenter(this);

        supplierViewPresenter = new SupplierViewPresenterImpl(clientFactory);
        bindModel();
    }

    @Override
    public SupplierEditDialog getView() {
        return null;
    }

    @Override
    public ClientFactory getClientFactory() {
        return clientFactory;
    }
}

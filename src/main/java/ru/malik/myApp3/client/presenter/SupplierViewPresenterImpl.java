package ru.malik.myApp3.client.presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.request.SupplierRequest;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;
import ru.malik.myApp3.client.view.SupplierEditor;
import ru.malik.myApp3.client.view.SupplierView;
import ru.malik.myApp3.client.view.SupplierViewImpl;

/**
 * Created by Малик on 01.12.2014.
 */
public class SupplierViewPresenterImpl implements SupplierViewPresenter{
    interface EditorDriver extends SimpleBeanEditorDriver<SupplierProxy, SupplierEditor> {
    }

    SupplierView view;


    private final EditorDriver editorDriver = GWT.create(EditorDriver.class);
    private SupplierRequest editRequest;

    ClientFactory clientFactory;

    @Override
    public void save() {
        SupplierProxy supplierProxy = editorDriver.flush();
        editRequest.saveOrUpdate(supplierProxy);
        editRequest.fire();
    }

    @Override
    public void edit(SupplierProxy supplier, SupplierRequest editRequest) {
        this.editRequest = editRequest;

        editorDriver.initialize((SupplierViewImpl)view);
        editorDriver.edit(this.editRequest.edit(supplier));
    }

    /*/@Override
    public void show(){
        view.show();
    }*/

    public SupplierViewPresenterImpl(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        view = clientFactory.getViewFactory().getSupplierView();
    }

    @Override
    public SupplierView getView() {
        return view;
    }

    @Override
    public ClientFactory getClientFactory() {
        return clientFactory;
    }
}

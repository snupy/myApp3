package ru.malik.myApp3.client.presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.request.InvoiceForPaymentRequest;
import ru.malik.myApp3.client.request.proxy.InvoiceForPaymentProxy;
import ru.malik.myApp3.client.view.InvoceForPaymentEditor;
import ru.malik.myApp3.client.view.InvoceForPaymentView;

/**
 * Created by Малик on 16.12.2014.
 */
public class InvoiceForPaymentViewPresenterImpl implements InvoiceForPaymentViewPresenter {
    interface EditorDriver extends SimpleBeanEditorDriver<InvoiceForPaymentProxy, InvoceForPaymentEditor> {
    }
    private InvoceForPaymentView view;

    private final EditorDriver editorDriver = GWT.create(EditorDriver.class);
    private InvoiceForPaymentRequest editRequest;

    ClientFactory clientFactory;

    @Override
    public void save() {
        InvoiceForPaymentProxy proxyObj = editorDriver.flush();
        editRequest.saveOrUpdate(proxyObj);
        editRequest.fire();
    }

    @Override
    public void edit(InvoiceForPaymentProxy proxyObj, InvoiceForPaymentRequest editRequest) {
        this.editRequest = editRequest;

        editorDriver.initialize(view);
        editorDriver.edit(this.editRequest.edit(proxyObj));
    }


    @Override
    public ClientFactory getClientFactory() {
        return clientFactory;
    }

    @Override
    public InvoceForPaymentView getView() {
        return view;
    }

    public InvoiceForPaymentViewPresenterImpl(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;

        this.view = clientFactory.getViewFactory().getInvoceForPaymentView();
        this.view.setPresenter(this);
    }
}

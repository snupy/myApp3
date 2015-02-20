package ru.malik.myApp3.client.presenter;

import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.request.InvoiceForPaymentRequest;
import ru.malik.myApp3.client.request.proxy.InvoiceForPaymentProxy;
import ru.malik.myApp3.client.view.dialogs.InvoiceForPaymentEditDialog;

/**
 * Created by Малик on 17.12.2014.
 */
public class InvoiceForPaymentEditDialogPresenterImpl extends AbstractPresenter<InvoiceForPaymentEditDialog> implements InvoiceForPaymentEditDialogPresenter {

    InvoiceForPaymentViewPresenter invoceForPaymentViewPresenter;


    @Override
    public void hide() {
        view.hide();
    }

    @Override
    public InvoiceForPaymentEditDialog getView() {
        return null;
    }

    @Override
    public void edit(InvoiceForPaymentProxy supplier, InvoiceForPaymentRequest editRequest) {
        invoceForPaymentViewPresenter.edit(supplier, editRequest);
    }

    @Override
    public void show() {
        view.show();
    }

    //@Override
    public void bindModel() {
        view.setContent(invoceForPaymentViewPresenter.getView());
    }

    @Override
    public void save() {
        invoceForPaymentViewPresenter.save();
    }


    public InvoiceForPaymentEditDialogPresenterImpl(ClientFactory clientFactory) {
        super(clientFactory);

        view = getClientFactory().getViewFactory().getDialogFactory().getInvoceForPaymentEditDialog();
        view.setPresenter(this);

        invoceForPaymentViewPresenter = new InvoiceForPaymentViewPresenterImpl(clientFactory);
        bindModel();
    }
}

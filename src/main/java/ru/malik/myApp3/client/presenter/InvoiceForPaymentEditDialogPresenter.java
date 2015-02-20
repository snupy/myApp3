package ru.malik.myApp3.client.presenter;

import ru.malik.myApp3.client.request.InvoiceForPaymentRequest;
import ru.malik.myApp3.client.request.proxy.InvoiceForPaymentProxy;
import ru.malik.myApp3.client.view.dialogs.InvoiceForPaymentEditDialog;

/**
 * Created by Малик on 04.01.2015.
 */
public interface InvoiceForPaymentEditDialogPresenter extends DialogPresenter<InvoiceForPaymentEditDialog>, EntityPresenter<InvoiceForPaymentEditDialog, InvoiceForPaymentProxy, InvoiceForPaymentRequest> {
}

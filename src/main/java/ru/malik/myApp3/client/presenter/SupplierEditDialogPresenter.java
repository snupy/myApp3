package ru.malik.myApp3.client.presenter;

import ru.malik.myApp3.client.request.SupplierRequest;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;
import ru.malik.myApp3.client.view.dialogs.SupplierEditDialog;

/**
 * Created by Малик on 31.12.2014.
 */
public interface SupplierEditDialogPresenter extends DialogPresenter<SupplierEditDialog>, EntityPresenter<SupplierEditDialog, SupplierProxy, SupplierRequest> {
}

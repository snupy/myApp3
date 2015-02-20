package ru.malik.myApp3.client.presenter;

import ru.malik.myApp3.client.event.SelectEvent;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;
import ru.malik.myApp3.client.view.dialogs.SupplierSelectDialog;

/**
 * Created by Малик on 14.01.2015.
 */
public interface SupplierSelectDialogPresenter extends DialogPresenter<SupplierSelectDialog>, SelectEvent.HasSelectHandlers {
    public void select();
}

package ru.malik.myApp3.client;

import ru.malik.myApp3.client.view.dialogs.BuildingProjectEditDialog;
import ru.malik.myApp3.client.view.dialogs.InvoiceForPaymentEditDialog;
import ru.malik.myApp3.client.view.dialogs.SupplierEditDialog;
import ru.malik.myApp3.client.view.dialogs.SupplierSelectDialog;

/**
 * Created by Малик on 21.12.2014.
 */
public interface DialogFactory {
    public SupplierEditDialog getSupplierEditDialog();
    public SupplierSelectDialog getSupplierSelectDialog();

    public BuildingProjectEditDialog getBuildingProjectEditDialog();

    public InvoiceForPaymentEditDialog getInvoceForPaymentEditDialog();
}

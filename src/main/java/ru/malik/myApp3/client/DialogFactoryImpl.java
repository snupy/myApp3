package ru.malik.myApp3.client;

import ru.malik.myApp3.client.view.dialogs.*;

/**
 * Created by Малик on 21.12.2014.
 */
public class DialogFactoryImpl implements DialogFactory{
    private final InvoiceForPaymentEditDialog invoceForPaymentEditDialog = new InvoiceForPaymentEditDialogImpl();

    private final BuildingProjectEditDialog buildingProjectEditDialog = new BuildingProjectEditDialogImpl();

    private final SupplierSelectDialog supplierSelectDialog = new SupplierSelectDialogImpl();
    private final SupplierEditDialog supplierEditDialog = new SupplierEditDialogImpl();

    @Override
    public SupplierEditDialog getSupplierEditDialog() {
        return supplierEditDialog;
    }

    @Override
    public SupplierSelectDialog getSupplierSelectDialog() {
        return supplierSelectDialog;
    }

    @Override
    public InvoiceForPaymentEditDialog getInvoceForPaymentEditDialog() {
        return invoceForPaymentEditDialog;
    }

    @Override
    public BuildingProjectEditDialog getBuildingProjectEditDialog() {
        return buildingProjectEditDialog;
    }
}

package ru.malik.myApp3.client;

import ru.malik.myApp3.client.view.*;

/**
 * Created by Малик on 21.12.2014.
 */
public interface ViewFactory {
    public DialogFactory getDialogFactory();

    public SuppliersListView getSuppliersListView();
    public SupplierView getSupplierView();

    public InvoiceForPaymentListView getInvoiceForPaymentListView();
    public InvoceForPaymentView getInvoceForPaymentView();

    public BuildingProjectListView getBuildingProjectListView();
    public BuildingProjectView getBuildingProjectView();

    public MainView getMainView();
}

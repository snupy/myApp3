package ru.malik.myApp3.client;

import com.google.gwt.core.client.GWT;
import ru.malik.myApp3.client.view.*;

/**
 * Created by Малик on 21.12.2014.
 */
public class ViewFactoryImpl implements ViewFactory {
    private final MainView mainView = new MainViewImpl();

    private final DialogFactory dialogFactory = GWT.create(DialogFactory.class);

    private final SuppliersListView suppliersListView = new SuppliersListViewImpl();
    private final SupplierView supplierView = new SupplierViewImpl();

    private final InvoiceForPaymentListView invoiceForPaymentListView = new InvoiceForPaymentListViewImpl();
    private final InvoceForPaymentView invoceForPaymentView = new InvoceForPaymentViewImpl();

    private final BuildingProjectListView buildingProjectListView = new BuildingProjectListViewImpl();
    private final BuildingProjectView buildingProjectView = new BuildingProjectViewImpl();

    @Override
    public DialogFactory getDialogFactory() {
        return dialogFactory;
    }

    @Override
    public SuppliersListView getSuppliersListView() {
        return suppliersListView;
    }


    @Override
    public SupplierView getSupplierView() {
        return supplierView;
    }


    @Override
    public InvoiceForPaymentListView getInvoiceForPaymentListView() {
        return invoiceForPaymentListView;
    }

    @Override
    public InvoceForPaymentView getInvoceForPaymentView() {
        return invoceForPaymentView;
    }

    @Override
    public BuildingProjectListView getBuildingProjectListView() {
        return buildingProjectListView;
    }

    @Override
    public BuildingProjectView getBuildingProjectView() {
        return buildingProjectView;
    }

    @Override
    public MainView getMainView() {
        return mainView;
    }
}

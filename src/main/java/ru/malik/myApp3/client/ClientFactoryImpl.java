package ru.malik.myApp3.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import ru.malik.myApp3.client.request.ApplicationRequestFactory;
import ru.malik.myApp3.client.view.*;
import ru.malik.myApp3.client.view.dialogs.*;

/**
 * Created by Малик on 04.11.2014.
 */
public class ClientFactoryImpl implements ClientFactory {
    private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);

    private final ViewFactory viewFactory = GWT.create(ViewFactory.class);

    private final MainView mainView = new MainViewImpl();

    private final SuppliersListView suppliersListView = new SuppliersListViewImpl();
    private final SupplierView supplierView = new SupplierViewImpl();
    private final SupplierSelectDialog supplierSelectDialog = new SupplierSelectDialogImpl();

    private final InvoiceForPaymentListView invoiceForPaymentListView = new InvoiceForPaymentListViewImpl();
    private final InvoceForPaymentView invoceForPaymentView = new InvoceForPaymentViewImpl();
    private final InvoiceForPaymentEditDialog invoceForPaymentEditDialog = new InvoiceForPaymentEditDialogImpl();

    private final ApplicationRequestFactory requestFactory = GWT.create(ApplicationRequestFactory.class);

    {
        requestFactory.initialize(eventBus);
    }

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }


    /*@Override
    public SuppliersListView getSuppliersListView() {
        return suppliersListView;
    }


    @Override
    public SupplierView getSupplierView() {
        return supplierView;
    }



    @Override
    public SupplierEditDialog getSupplierEditDialog() {
        return new SupplierEditDialogImpl();
    }

    @Override
    public SupplierSelectDialog getSupplierSelectDialog() {
        return supplierSelectDialog;
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
    public InvoceForPaymentEditDialog getInvoceForPaymentEditDialog() {
        return invoceForPaymentEditDialog;
    }

    @Override
    public MainView getMainView() {
        return mainView;
    }*/

    @Override
    public ViewFactory getViewFactory() {
        return viewFactory;
    }
    @Override
    public ApplicationRequestFactory getRequestFactory() {
        return requestFactory;
    }
}

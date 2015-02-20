package ru.malik.myApp3.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import ru.malik.myApp3.client.request.ApplicationRequestFactory;

/**
 * Created by Малик on 04.11.2014.
 */
public interface ClientFactory {
    EventBus getEventBus();
    PlaceController getPlaceController();

    ViewFactory getViewFactory();

    /*MainView getMainView();

    SuppliersListView getSuppliersListView();
    SupplierView getSupplierView();
    SupplierEditDialog getSupplierEditDialog();
    SupplierSelectDialog getSupplierSelectDialog();

    InvoiceForPaymentListView getInvoiceForPaymentListView();
    InvoceForPaymentView getInvoceForPaymentView();
    InvoceForPaymentEditDialog getInvoceForPaymentEditDialog();*/

    ApplicationRequestFactory  getRequestFactory();
}

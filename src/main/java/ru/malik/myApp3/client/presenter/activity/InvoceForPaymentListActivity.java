package ru.malik.myApp3.client.presenter.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.place.InvoceForPaymentListPlace;
import ru.malik.myApp3.client.presenter.InvoiceForPaymentListPresenterImpl;

/**
 * Created by Зуфар on 20.12.2014.
 */
public class InvoceForPaymentListActivity extends SimpleActivity<InvoceForPaymentListPlace> {
    InvoiceForPaymentListPresenterImpl invoiceForPaymentListPresenter;
    IsWidget view;

    protected InvoceForPaymentListActivity(InvoceForPaymentListPlace place, ClientFactory clientFactory) {
        super(place, clientFactory);
        invoiceForPaymentListPresenter = new InvoiceForPaymentListPresenterImpl(clientFactory);
        view = invoiceForPaymentListPresenter.getView();
    }

    @Override
    public void start(AcceptsOneWidget acceptsOneWidget, EventBus eventBus) {
        acceptsOneWidget.setWidget(view);
    }
}

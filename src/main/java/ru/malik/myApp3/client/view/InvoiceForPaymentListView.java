package ru.malik.myApp3.client.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import ru.malik.myApp3.client.presenter.InvoiceForPaymentListPresenter;

/**
 * Created by Малик on 14.12.2014.
 */
public interface InvoiceForPaymentListView extends IsWidget, View<InvoiceForPaymentListPresenter> {
    void setListLoader(PagingLoader listLoader);
}

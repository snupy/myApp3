package ru.malik.myApp3.client.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.widget.core.client.ContentPanel;

/**
 * Created by Зуфар on 20.12.2014.
 */
public interface MainView extends IsWidget {
    void setPresenter(Presenter presenter);

    public ContentPanel getCenterPanel();

    public interface Presenter {
        public void showSupplierListView();

        public void showInvoiceForPaymentListView();
        public void showBuildingProjectListView();
    }
}


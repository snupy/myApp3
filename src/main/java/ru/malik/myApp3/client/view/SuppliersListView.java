package ru.malik.myApp3.client.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import ru.malik.myApp3.client.presenter.SuppliersListPresenter;

/**
 * Created by Малик on 09.11.2014.
 */
public interface SuppliersListView extends IsWidget, View<SuppliersListPresenter> {
    void setListLoader(PagingLoader listLoader);
}

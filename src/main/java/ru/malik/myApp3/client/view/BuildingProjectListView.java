package ru.malik.myApp3.client.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import ru.malik.myApp3.client.presenter.BuildingProjectListPresenter;

/**
 * Created by Зуфар on 23.12.2014.
 */
public interface BuildingProjectListView extends IsWidget, View<BuildingProjectListPresenter> {
    void setListLoader(PagingLoader listLoader);
}

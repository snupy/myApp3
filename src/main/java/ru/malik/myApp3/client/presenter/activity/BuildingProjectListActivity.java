package ru.malik.myApp3.client.presenter.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.place.BuildingProjectListPlace;
import ru.malik.myApp3.client.presenter.BuildingProjectListPresenter;
import ru.malik.myApp3.client.presenter.BuildingProjectListPresenterImpl;
import ru.malik.myApp3.client.view.BuildingProjectListView;

/**
 * Created by Зуфар on 23.12.2014.
 */
public class BuildingProjectListActivity extends SimpleActivity<BuildingProjectListPlace> {
    BuildingProjectListPresenter buildingProjectListPresenter;
    IsWidget view;

    protected BuildingProjectListActivity(BuildingProjectListPlace place, ClientFactory clientFactory) {
        super(place, clientFactory);
        buildingProjectListPresenter = new BuildingProjectListPresenterImpl(clientFactory);
        view = buildingProjectListPresenter.getView();
    }

    @Override
    public void start(AcceptsOneWidget acceptsOneWidget, EventBus eventBus) {
        acceptsOneWidget.setWidget(view);
    }
}

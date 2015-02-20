package ru.malik.myApp3.client.presenter.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.place.SuppliersListPlace;
import ru.malik.myApp3.client.presenter.SuppliersListPresenterImpl;

/**
 * Created by Малик on 09.11.2014.
 */
public class SuppliersListActvity extends SimpleActivity<SuppliersListPlace> {

    IsWidget view;
    SuppliersListPresenterImpl suppliersListPresenter;

    protected SuppliersListActvity(SuppliersListPlace place, ClientFactory clientFactory) {
        super(place, clientFactory);


        suppliersListPresenter = new SuppliersListPresenterImpl(clientFactory);

        view = suppliersListPresenter.getView();

    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        panel.setWidget(view.asWidget());
    }


}

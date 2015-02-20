package ru.malik.myApp3.client.presenter.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.place.BuildingProjectListPlace;
import ru.malik.myApp3.client.place.InvoceForPaymentListPlace;
import ru.malik.myApp3.client.place.SuppliersListPlace;

/**
 * Created by Малик on 04.11.2014.
 */
public class AppActivityMapper implements ActivityMapper {
    private ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }


    @Override
    public Activity getActivity(Place place) {
        if (place instanceof SuppliersListPlace)
            return new SuppliersListActvity((SuppliersListPlace) place, clientFactory);
        else if (place instanceof InvoceForPaymentListPlace)
            return new InvoceForPaymentListActivity((InvoceForPaymentListPlace) place, clientFactory);
        else if (place instanceof BuildingProjectListPlace)
            return new BuildingProjectListActivity((BuildingProjectListPlace) place, clientFactory);
        else
            return null;
    }

}

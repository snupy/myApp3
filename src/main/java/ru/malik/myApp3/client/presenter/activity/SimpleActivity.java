package ru.malik.myApp3.client.presenter.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.Place;
import ru.malik.myApp3.client.ClientFactory;

/**
 * Created by Малик on 09.11.2014.
 */
public abstract class SimpleActivity<T extends Place> extends AbstractActivity {
    ClientFactory clientFactory;

    protected SimpleActivity(T place, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

}

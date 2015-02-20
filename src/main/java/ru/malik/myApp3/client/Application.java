package ru.malik.myApp3.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.widget.core.client.container.Viewport;
import ru.malik.myApp3.client.presenter.MainViewPresenter;
import ru.malik.myApp3.client.presenter.activity.AppActivityMapper;
import ru.malik.myApp3.client.place.AppPlaceHistoryMapper;
import ru.malik.myApp3.client.place.SuppliersListPlace;
import ru.malik.myApp3.client.view.MainView;
import ru.malik.myApp3.client.view.MainViewImpl;

/**
 * Created by Малик on 03.11.2014.
 */
public class Application implements EntryPoint {
    private Place defaultPlace = new SuppliersListPlace();
    private MainView appWidget;

    public void onModuleLoad() {


        ClientFactory clientFactory = GWT.create(ClientFactory.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        appWidget = new MainViewPresenter(clientFactory).getView();

        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(appWidget.getCenterPanel());

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);


        Viewport viewport = new Viewport();
        viewport.setWidget(appWidget);
        RootPanel.get().add(viewport);
        // Goes to the place represented on URL else default place
        historyHandler.handleCurrentHistory();

    }

}

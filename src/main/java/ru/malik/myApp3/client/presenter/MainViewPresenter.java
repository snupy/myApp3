package ru.malik.myApp3.client.presenter;

import com.google.gwt.event.shared.HandlerRegistration;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.event.OkEvent;
import ru.malik.myApp3.client.place.BuildingProjectListPlace;
import ru.malik.myApp3.client.place.InvoceForPaymentListPlace;
import ru.malik.myApp3.client.place.SuppliersListPlace;
import ru.malik.myApp3.client.view.MainView;

/**
 * Created by Зуфар on 20.12.2014.
 */
public class MainViewPresenter implements MainView.Presenter{
    ClientFactory clientFactory;
    MainView view;

    public MainViewPresenter(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;

        view = clientFactory.getViewFactory().getMainView();
        view.setPresenter(this);
    }

    @Override
    public void showSupplierListView() {
        clientFactory.getPlaceController().goTo(new SuppliersListPlace());
    }

    @Override
    public void showInvoiceForPaymentListView() {
        clientFactory.getPlaceController().goTo(new InvoceForPaymentListPlace());
    }

    @Override
    public void showBuildingProjectListView() {
        clientFactory.getPlaceController().goTo(new BuildingProjectListPlace());
    }

    public MainView getView() {
        return view;
    }

}

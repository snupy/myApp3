package ru.malik.myApp3.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

/**
 * Created by Зуфар on 19.12.2014.
 */
public class MainViewImpl extends Composite implements MainView {


    interface MainViewUiBinder extends UiBinder<SimpleContainer, MainViewImpl> {
    }

    @UiField(provided = true)
    MarginData outerData = new MarginData(10);
    @UiField(provided = true)
    BorderLayoutData northData = new BorderLayoutData(100);
    @UiField(provided = true)
    BorderLayoutData westData = new BorderLayoutData(150);
    @UiField(provided = true)
    MarginData centerData = new MarginData();
    @UiField(provided = true)
    BorderLayoutData eastData = new BorderLayoutData(150);
    @UiField(provided = true)
    BorderLayoutData southData = new BorderLayoutData(100);
    @UiField
    BorderLayoutContainer con;
    @UiField
    ContentPanel centerPanel;
    @UiField
    ContentPanel westPanel;

    Presenter presenter;

    private static MainViewUiBinder ourUiBinder = GWT.create(MainViewUiBinder.class);

    public MainViewImpl() {
        northData.setMargins(new Margins(5));
        northData.setHidden(true);

        westData.setMargins(new Margins(0, 5, 0, 5));
        westData.setCollapsible(true);
        westData.setSplit(true);

        eastData.setMargins(new Margins(0, 5, 0, 5));
        eastData.setHidden(true);

        southData.setMargins(new Margins(5));
        southData.setHidden(true);

        initWidget(ourUiBinder.createAndBindUi(this));

    }

    public ContentPanel getCenterPanel() {
        return centerPanel;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @UiHandler("supplierBtn")
    public void supplierBtnClk(SelectEvent event) {
        presenter.showSupplierListView();
    }

    @UiHandler("invoceForPaymentBtn")
    public void invoceForPaymentBtnClk(SelectEvent event) {
        presenter.showInvoiceForPaymentListView();
    }

    @UiHandler("buildProjectBtn")
    public void buildProjectBtnClk(SelectEvent event) {
        presenter.showBuildingProjectListView();
    }
}
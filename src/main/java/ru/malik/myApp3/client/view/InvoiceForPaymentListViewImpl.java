package ru.malik.myApp3.client.view;

import com.google.gwt.core.client.GWT;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.*;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.event.RefreshEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.filters.DateFilter;
import com.sencha.gxt.widget.core.client.grid.filters.GridFilters;
import com.sencha.gxt.widget.core.client.grid.filters.StringFilter;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import ru.malik.myApp3.client.presenter.InvoiceForPaymentListPresenter;
import ru.malik.myApp3.client.request.proxy.InvoiceForPaymentProxy;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;
import ru.malik.myApp3.client.view.model.InvoiceForPaymentProperties;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Малик on 14.12.2014.
 */
public class InvoiceForPaymentListViewImpl extends Composite implements InvoiceForPaymentListView {
    interface InvoiceForPaymentListViewImplUiBinder extends UiBinder<Widget, InvoiceForPaymentListViewImpl> {
    }

    private static InvoiceForPaymentListViewImplUiBinder ourUiBinder = GWT.create(InvoiceForPaymentListViewImplUiBinder.class);

    private InvoiceForPaymentListPresenter presenter;


    @UiField(provided = true)
    ListStore store;

    @UiField(provided = true)
    ColumnModel cm;

    @UiField(provided = true)
    CheckBoxSelectionModel<InvoiceForPaymentProxy> sm;

    @UiField
    Grid grid;

    @UiField
    PagingToolBar pagingToolBar;

    GridFilters<InvoiceForPaymentProxy> filters;

    final InvoiceForPaymentProperties props = GWT.create(InvoiceForPaymentProperties.class);

    public InvoiceForPaymentListViewImpl() {
        store = new ListStore<InvoiceForPaymentProxy>(props.id());

        IdentityValueProvider<InvoiceForPaymentProxy> identity = new IdentityValueProvider<InvoiceForPaymentProxy>();


        List<ColumnConfig<InvoiceForPaymentProxy, ?>> columnConfigs = new ArrayList<ColumnConfig<InvoiceForPaymentProxy, ?>>();

        sm = new CheckBoxSelectionModel<InvoiceForPaymentProxy>(identity) {
            @Override
            protected void onRefresh(RefreshEvent event) {
                if (isSelectAllChecked()) {
                    selectAll();
                }
                super.onRefresh(event);
            }
        };
        columnConfigs.add(sm.getColumn());

        ColumnConfig<InvoiceForPaymentProxy, Date> dateColumn = new ColumnConfig<InvoiceForPaymentProxy, Date>(props.date(), 150, "Дата");
        columnConfigs.add(dateColumn);

        ColumnConfig<InvoiceForPaymentProxy, String> numberColumn = new ColumnConfig<InvoiceForPaymentProxy, String>(props.number(), 150, "Номер");
        columnConfigs.add(numberColumn);

        ColumnConfig<InvoiceForPaymentProxy, String> supplierColumn = new ColumnConfig<InvoiceForPaymentProxy, String>(props.supplier(), 150, "Постащик");
        columnConfigs.add(supplierColumn);

        ColumnConfig<InvoiceForPaymentProxy, Double> priceSumColumn = new ColumnConfig<InvoiceForPaymentProxy, Double>(props.priceSum(), 150, "Сумма");
        columnConfigs.add(priceSumColumn);

        cm = new ColumnModel(columnConfigs);


        initWidget(ourUiBinder.createAndBindUi(this));
    }


    @Override
    public void setListLoader(PagingLoader listLoader) {
        listLoader.setRemoteSort(true);

        listLoader.addLoadHandler(new LoadResultListStoreBinding<FilterPagingLoadConfig, InvoiceForPaymentProxy, PagingLoadResult<InvoiceForPaymentProxy>>(store));

        pagingToolBar.bind(listLoader);

        grid.setLoader(listLoader);

        setFilters(listLoader);
    }

    public void setFilters(Loader loader) {
        filters = new GridFilters<InvoiceForPaymentProxy>(loader);
        filters.initPlugin(grid);
        filters.setLocal(false);
        filters.addFilter(new StringFilter<InvoiceForPaymentProxy>(props.number()));
        filters.addFilter(new DateFilter<InvoiceForPaymentProxy>(props.date()));
    }


    @Override
    public void setPresenter(InvoiceForPaymentListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public InvoiceForPaymentListPresenter getPresenter() {
        return this.presenter;
    }

    @UiHandler("editBtn")
    public void editClicked(SelectEvent event) {
        List<InvoiceForPaymentProxy> list = grid.getSelectionModel().getSelection();
        if (list.size() > 0) {
            presenter.editItem(list.get(list.size() - 1));
        }
    }

    @UiHandler("addBtn")
    public void addClicked(SelectEvent event) {
        presenter.addItem();
    }
}
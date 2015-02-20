package ru.malik.myApp3.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
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
import com.sencha.gxt.widget.core.client.grid.filters.GridFilters;
import com.sencha.gxt.widget.core.client.grid.filters.StringFilter;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.presenter.SuppliersListPresenter;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;
import ru.malik.myApp3.client.view.model.SupplierProxyProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Малик on 06.11.2014.
 */
public class SuppliersListViewImpl extends Composite implements SuppliersListView {
    private SuppliersListPresenter presenter;

    interface SuppliersListViewUiBinder extends UiBinder<Widget, SuppliersListViewImpl> {
    }


    @UiField(provided = true)
    ListStore store;

    @UiField(provided = true)
    ColumnModel cm;

    @UiField(provided = true)
    CheckBoxSelectionModel<SupplierProxy> sm;

    @UiField
    Grid grid;

    @UiField
    PagingToolBar pagingToolBar;

    GridFilters<SupplierProxy> filters;

    final SupplierProxyProperties props = GWT.create(SupplierProxyProperties.class);

    private static SuppliersListViewUiBinder ourUiBinder = GWT.create(SuppliersListViewUiBinder.class);

    public SuppliersListViewImpl() {


        store = new ListStore<SupplierProxy>(props.id());

        IdentityValueProvider<SupplierProxy> identity = new IdentityValueProvider<SupplierProxy>();
        sm = new CheckBoxSelectionModel<SupplierProxy>(identity) {
            @Override
            protected void onRefresh(RefreshEvent event) {
                if (isSelectAllChecked()) {
                    selectAll();
                }
                super.onRefresh(event);
            }
        };

        ColumnConfig<SupplierProxy, String> nameColumn = new ColumnConfig<SupplierProxy, String>(props.name(), 150, "Наименование");
        List<ColumnConfig<SupplierProxy, ?>> columnConfigs = new ArrayList<ColumnConfig<SupplierProxy, ?>>();
        columnConfigs.add(sm.getColumn());
        columnConfigs.add(nameColumn);
        cm = new ColumnModel(columnConfigs);


        initWidget(ourUiBinder.createAndBindUi(this));

    }

    @Override
    public void setListLoader(PagingLoader listLoader) {
        listLoader.setRemoteSort(true);

        listLoader.addLoadHandler(new LoadResultListStoreBinding<FilterPagingLoadConfig, SupplierProxy, PagingLoadResult<SupplierProxy>>(store));

        pagingToolBar.bind(listLoader);

        grid.setLoader(listLoader);

        setFilters(listLoader);

        listLoader.load();

    }


    public void setFilters(Loader loader) {
        filters = new GridFilters<SupplierProxy>(loader);


        filters.initPlugin(grid);

        filters.setLocal(false);

        filters.addFilter(new StringFilter<SupplierProxy>(props.name()));

    }

    @Override
    public void setPresenter(SuppliersListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public SuppliersListPresenter getPresenter() {
        return this.presenter;
    }

    @UiHandler(value = "addBtn")
    public void addClicked(SelectEvent event) {
        presenter.addItem();
    }

    @UiHandler("deleteBtn")
    public void deleteClicked(SelectEvent event) {
        presenter.deleteItem(grid.getSelectionModel().getSelection());
    }

    @UiHandler("editBtn")
    public void editClicked(SelectEvent event) {
        SupplierProxy sel = (SupplierProxy) grid.getSelectionModel().getSelectedItem();
        if (sel != null) {
            presenter.editItem(sel);
        }
    }

    @UiHandler("sm")
    public void selected(SelectionEvent<SupplierProxy> event) {
        presenter.selectItem(event.getSelectedItem());
    }
}
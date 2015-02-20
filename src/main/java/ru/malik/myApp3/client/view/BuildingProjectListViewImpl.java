package ru.malik.myApp3.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.FilterPagingLoadConfig;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.event.RefreshEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import ru.malik.myApp3.client.presenter.BuildingProjectListPresenter;
import ru.malik.myApp3.client.request.proxy.BuildingProjectProxy;
import ru.malik.myApp3.client.view.model.BuildingProjectProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Зуфар on 23.12.2014.
 */
public class BuildingProjectListViewImpl extends Composite implements BuildingProjectListView {
    interface BuildingProjectListViewImplUiBinder extends UiBinder<FramedPanel, BuildingProjectListViewImpl> {
    }

    private static BuildingProjectListViewImplUiBinder ourUiBinder = GWT.create(BuildingProjectListViewImplUiBinder.class);

    final BuildingProjectProperties props = GWT.create(BuildingProjectProperties.class);

    private BuildingProjectListPresenter presenter;

    @UiField(provided = true)
    ListStore store;

    @UiField(provided = true)
    ColumnModel cm;

    @UiField(provided = true)
    CheckBoxSelectionModel<BuildingProjectProxy> sm;

    @UiField
    Grid grid;

    @UiField
    PagingToolBar pagingToolBar;


    @Override
    public void setPresenter(BuildingProjectListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public BuildingProjectListPresenter getPresenter() {
        return this.presenter;
    }

    @Override
    public void setListLoader(PagingLoader listLoader) {
        listLoader.setRemoteSort(true);

        listLoader.addLoadHandler(new LoadResultListStoreBinding<FilterPagingLoadConfig, BuildingProjectProxy, PagingLoadResult<BuildingProjectProxy>>(store));

        pagingToolBar.bind(listLoader);

        grid.setLoader(listLoader);

        listLoader.load();
    }

    public BuildingProjectListViewImpl() {
        store = new ListStore<BuildingProjectProxy>(props.id());

        IdentityValueProvider<BuildingProjectProxy> identity = new IdentityValueProvider<BuildingProjectProxy>();


        List<ColumnConfig<BuildingProjectProxy, ?>> columnConfigs = new ArrayList<ColumnConfig<BuildingProjectProxy, ?>>();

        sm = new CheckBoxSelectionModel<BuildingProjectProxy>(identity) {
            @Override
            protected void onRefresh(RefreshEvent event) {
                if (isSelectAllChecked()) {
                    selectAll();
                }
                super.onRefresh(event);
            }
        };
        columnConfigs.add(sm.getColumn());

        ColumnConfig<BuildingProjectProxy, String> nameColumn = new ColumnConfig<BuildingProjectProxy, String>(props.name(), 150, "Имя");
        columnConfigs.add(nameColumn);

        cm = new ColumnModel(columnConfigs);


        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("addBtn")
    public void addClicked(SelectEvent event){
        presenter.addItem();
    }

    @UiHandler("editBtn")
    public void editClicked(SelectEvent event) {
        BuildingProjectProxy sel = (BuildingProjectProxy) grid.getSelectionModel().getSelectedItem();
        if (sel != null) {
            presenter.editItem(sel);
        }
    }
}
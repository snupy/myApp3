package ru.malik.myApp3.client.presenter;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.sencha.gxt.data.shared.SortInfo;
import com.sencha.gxt.data.shared.loader.*;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.request.BuildingProjectRequest;
import ru.malik.myApp3.client.request.proxy.BuildingProjectProxy;
import ru.malik.myApp3.client.view.BuildingProjectListView;
import ru.malik.myApp3.server.business.types.BuildingProject;

import java.util.List;

/**
 * Created by Зуфар on 23.12.2014.
 */
public class BuildingProjectListPresenterImpl extends AbstractListViewPresenter<BuildingProjectListView, BuildingProjectProxy> implements BuildingProjectListPresenter {
    BuildingProjectListView view;
    ClientFactory clientFactory;


    public BuildingProjectListPresenterImpl(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        view = clientFactory.getViewFactory().getBuildingProjectListView();
        view.setPresenter(this);
        bindModel();
    }

    public void bindModel() {
        RequestFactoryProxy<FilterPagingLoadConfig, PagingLoadResult<BuildingProjectProxy>> proxy = new RequestFactoryProxy<FilterPagingLoadConfig, PagingLoadResult<BuildingProjectProxy>>() {
            @Override
            public void load(FilterPagingLoadConfig loadConfig, Receiver<? super PagingLoadResult<BuildingProjectProxy>> receiver) {
                BuildingProjectRequest request = clientFactory.getRequestFactory().buildingProjectRequest();
                List<SortInfo> sortInfos = createRequestSortInfo(request, loadConfig.getSortInfo());
                List<FilterConfig> filterConfigs = createRequestFilterConfig(request, loadConfig.getFilters());
                request.getPagingList(loadConfig.getOffset(), loadConfig.getLimit(), sortInfos, filterConfigs).to(receiver);
                request.fire();
            }
        };

        final PagingLoader<FilterPagingLoadConfig, PagingLoadResult<BuildingProjectProxy>> loader = new PagingLoader<FilterPagingLoadConfig, PagingLoadResult<BuildingProjectProxy>>(proxy) {
            @Override
            protected FilterPagingLoadConfig newLoadConfig() {
                return new FilterPagingLoadConfigBean();
            }
        };

        view.setListLoader(loader);
    }

    @Override
    public BuildingProjectListView getView() {
        return view;
    }

    @Override
    public ClientFactory getClientFactory() {
        return clientFactory;
    }

    @Override
    public void addItem() {
        BuildingProjectRequest request = getClientFactory().getRequestFactory().buildingProjectRequest();
        BuildingProjectEditDialogPresenter dialogPresenter = new BuildingProjectEditDialogPresenterImpl(getClientFactory());
        dialogPresenter.edit(request.create(BuildingProjectProxy.class),request);
        dialogPresenter.show();
    }

    @Override
    public void deleteItem(List<BuildingProjectProxy> list) {
        //TODO метод надо заполнить
    }

    @Override
    public void editItem(BuildingProjectProxy item) {
        BuildingProjectRequest request = getClientFactory().getRequestFactory().buildingProjectRequest();
        BuildingProjectEditDialogPresenter dialogPresenter = new BuildingProjectEditDialogPresenterImpl(getClientFactory());
        dialogPresenter.edit(request.edit(item),request);
        dialogPresenter.show();
    }

    @Override
    public void selectItem(BuildingProjectProxy obj) {
        //TODO метод надо заполнить
    }


}

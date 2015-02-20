package ru.malik.myApp3.client.presenter;

import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.request.BuildingProjectRequest;
import ru.malik.myApp3.client.request.proxy.BuildingProjectProxy;
import ru.malik.myApp3.client.view.dialogs.BuildingProjectEditDialog;

/**
 * Created by Малик on 05.01.2015.
 */
public class BuildingProjectEditDialogPresenterImpl extends AbstractPresenter<BuildingProjectEditDialog> implements BuildingProjectEditDialogPresenter {
    private BuildingProjectViewPresenter buildingProjectViewPresenter;

    @Override
    public void show() {
        view.show();
    }

    @Override
    public void hide() {
        view.hide();
    }

    @Override
    public void edit(BuildingProjectProxy obj, BuildingProjectRequest request) {
        buildingProjectViewPresenter.edit(obj, request);
    }

    @Override
    public void save() {
        buildingProjectViewPresenter.save();
    }

    protected BuildingProjectEditDialogPresenterImpl(ClientFactory clientFactory) {
        super(clientFactory);

        view = getClientFactory().getViewFactory().getDialogFactory().getBuildingProjectEditDialog();
        view.setPresenter(this);

        buildingProjectViewPresenter = new BuildingProjectViewPresenterImpl(getClientFactory());
        view.setContent(buildingProjectViewPresenter.getView());
    }
}

package ru.malik.myApp3.client.presenter;

import ru.malik.myApp3.client.request.BuildingProjectRequest;
import ru.malik.myApp3.client.request.proxy.BuildingProjectProxy;
import ru.malik.myApp3.client.view.dialogs.BuildingProjectEditDialog;

/**
 * Created by Малик on 05.01.2015.
 */
public interface BuildingProjectEditDialogPresenter extends DialogPresenter<BuildingProjectEditDialog>, EntityPresenter<BuildingProjectEditDialog, BuildingProjectProxy, BuildingProjectRequest> {
}

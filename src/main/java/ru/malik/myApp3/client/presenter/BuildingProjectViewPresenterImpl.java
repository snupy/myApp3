package ru.malik.myApp3.client.presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.request.BuildingProjectRequest;
import ru.malik.myApp3.client.request.proxy.BuildingProjectProxy;
import ru.malik.myApp3.client.view.BuildingProjectEditor;
import ru.malik.myApp3.client.view.BuildingProjectView;

/**
 * Created by Малик on 05.01.2015.
 */
public class BuildingProjectViewPresenterImpl extends AbstractPresenter<BuildingProjectView> implements BuildingProjectViewPresenter {
    interface EditorDriver extends SimpleBeanEditorDriver<BuildingProjectProxy, BuildingProjectEditor> {
    }

    private final EditorDriver editorDriver = GWT.create(EditorDriver.class);
    private BuildingProjectRequest editRequest;

    protected BuildingProjectViewPresenterImpl(ClientFactory clientFactory) {
        super(clientFactory);

        view = getClientFactory().getViewFactory().getBuildingProjectView();
        view.setPresenter(this);
    }

    @Override
    public void edit(BuildingProjectProxy obj, BuildingProjectRequest request) {
        this.editRequest = request;

        editorDriver.initialize(view);
        editorDriver.edit(this.editRequest.edit(obj));
    }

    @Override
    public void save() {
        editRequest.saveOrUpdate(editorDriver.flush());
        editRequest.fire();
    }
}

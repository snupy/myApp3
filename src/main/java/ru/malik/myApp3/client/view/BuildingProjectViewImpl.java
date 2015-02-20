package ru.malik.myApp3.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.form.TextField;
import ru.malik.myApp3.client.presenter.BuildingProjectViewPresenter;

/**
 * Created by Малик on 05.01.2015.
 */
public class BuildingProjectViewImpl extends Composite implements BuildingProjectView {
    interface BuildingProjectViewImplUiBinder extends UiBinder<Widget, BuildingProjectViewImpl> {
    }

    private static BuildingProjectViewImplUiBinder ourUiBinder = GWT.create(BuildingProjectViewImplUiBinder.class);

    private BuildingProjectViewPresenter presenter;

    @UiField
    TextField nameField;

    public BuildingProjectViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    public TextField getNameField() {
        return this.nameField;
    }

    @Override
    public void setPresenter(BuildingProjectViewPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public BuildingProjectViewPresenter getPresenter() {
        return this.presenter;
    }
}
package ru.malik.myApp3.client.view.dialogs;

import com.google.gwt.user.client.ui.IsWidget;
import ru.malik.myApp3.client.presenter.BuildingProjectEditDialogPresenter;

/**
 * Created by Малик on 05.01.2015.
 */
public class BuildingProjectEditDialogImpl extends EditDialog implements BuildingProjectEditDialog {
    private BuildingProjectEditDialogPresenter presenter;

    @Override
    public void setContent(IsWidget widget) {
        setWidget(widget);
    }

    @Override
    public void setPresenter(BuildingProjectEditDialogPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public BuildingProjectEditDialogPresenter getPresenter() {
        return this.presenter;
    }

    @Override
    public void onSave() {
        super.onSave();
        presenter.save();
    }
}

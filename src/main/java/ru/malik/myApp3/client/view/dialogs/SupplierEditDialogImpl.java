package ru.malik.myApp3.client.view.dialogs;

import com.google.gwt.user.client.ui.IsWidget;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.presenter.SupplierEditDialogPresenter;

/**
 * Created by Малик on 01.12.2014.
 */
public class SupplierEditDialogImpl extends EditDialog implements SupplierEditDialog {

    private SupplierEditDialogPresenter presenter;

    @Override
    public void setPresenter(SupplierEditDialogPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public SupplierEditDialogPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void show(){
        super.show();
    }

    @Override
    public void setContent(IsWidget widget) {
        setWidget(widget);
    }

    @Override
    public void onSave() {
        super.onSave();
        presenter.save();
    }
}

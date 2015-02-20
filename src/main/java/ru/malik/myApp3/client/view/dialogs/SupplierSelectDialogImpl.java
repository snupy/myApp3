package ru.malik.myApp3.client.view.dialogs;

import com.google.gwt.user.client.ui.IsWidget;
import ru.malik.myApp3.client.presenter.SupplierSelectDialogPresenter;

/**
 * Created by Зуфар on 20.12.2014.
 */
public class SupplierSelectDialogImpl extends SelectDialog implements SupplierSelectDialog {
    private SupplierSelectDialogPresenter presenter;

    @Override
    public void setPresenter(SupplierSelectDialogPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public SupplierSelectDialogPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void setContent(IsWidget widget) {
        this.setWidget(widget);
    }

    @Override
    public void onOk() {
        super.onOk();
        presenter.select();
    }
}

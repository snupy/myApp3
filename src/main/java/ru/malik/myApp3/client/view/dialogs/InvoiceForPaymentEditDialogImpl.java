package ru.malik.myApp3.client.view.dialogs;

import com.google.gwt.user.client.ui.IsWidget;
import ru.malik.myApp3.client.presenter.InvoiceForPaymentEditDialogPresenter;

/**
 * Created by Малик on 17.12.2014.
 */
public class InvoiceForPaymentEditDialogImpl extends EditDialog implements InvoiceForPaymentEditDialog {
    private InvoiceForPaymentEditDialogPresenter presenter;

    @Override
    public void setPresenter(InvoiceForPaymentEditDialogPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public InvoiceForPaymentEditDialogPresenter getPresenter() {
        return presenter;
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

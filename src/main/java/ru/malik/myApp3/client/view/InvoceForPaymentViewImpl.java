package ru.malik.myApp3.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.DoubleField;
import com.sencha.gxt.widget.core.client.form.TextField;
import ru.malik.myApp3.client.presenter.InvoiceForPaymentViewPresenter;
import ru.malik.myApp3.client.presenter.SupplierSelectDialogPresenterImpl;
import ru.malik.myApp3.client.view.widget.SupplierField;

/**
 * Created by Малик on 16.12.2014.
 */
public class InvoceForPaymentViewImpl extends Composite implements InvoceForPaymentView {

    interface InvoceForPaymentViewImplUiBinder extends UiBinder<Widget, InvoceForPaymentViewImpl> {
    }

    private static InvoceForPaymentViewImplUiBinder ourUiBinder = GWT.create(InvoceForPaymentViewImplUiBinder.class);

    private InvoiceForPaymentViewPresenter presenter;

    @UiField
    TextField number;
    @UiField
    DateField date;
    @UiField
    SupplierField supplierField;
    @UiField
    DoubleField priceSumField;

    @Override
    public TextField getNumberField() {
        return number;
    }

    @Override
    public DateField getDateField() {
        return date;
    }

    @Override
    public SupplierField getSupplierField() {
        return supplierField;
    }

    @Override
    public DoubleField getPriceSumField() {
        return priceSumField;
    }

    @Override
    public void setPresenter(InvoiceForPaymentViewPresenter presenter) {
        this.presenter = presenter;
        SupplierSelectDialogPresenterImpl selectDialogPresenter = new SupplierSelectDialogPresenterImpl(presenter.getClientFactory());
        supplierField.setClientFactory(presenter.getClientFactory());
    }

    @Override
    public InvoiceForPaymentViewPresenter getPresenter() {
        return presenter;

    }

    public InvoceForPaymentViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));

    }
}
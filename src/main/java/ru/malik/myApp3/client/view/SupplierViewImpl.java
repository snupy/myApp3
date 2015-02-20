package ru.malik.myApp3.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.form.TextField;
import ru.malik.myApp3.client.presenter.SupplierViewPresenter;


/**
 * Created by Малик on 10.11.2014.
 */
public class SupplierViewImpl extends Composite implements SupplierView {

    interface SupplierViewImplUiBinder extends UiBinder<Widget, SupplierViewImpl> {
    }

    private static SupplierViewImplUiBinder ourUiBinder = GWT.create(SupplierViewImplUiBinder.class);

    @UiField
    TextField name;

    private SupplierViewPresenter presenter;

    @Override
    public void setPresenter(SupplierViewPresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public SupplierViewPresenter getPresenter() {
        return presenter;
    }

    @Override
    public TextField getNameField() {
        return name;
    }

    public SupplierViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

}
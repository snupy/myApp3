package ru.malik.myApp3.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.DoubleField;
import com.sencha.gxt.widget.core.client.form.TextField;
import ru.malik.myApp3.client.request.proxy.InvoiceForPaymentProxy;
import ru.malik.myApp3.client.view.widget.SupplierField;

import java.beans.PropertyEditor;

/**
 * Created by Малик on 16.12.2014.
 */
public interface InvoceForPaymentEditor extends Editor<InvoiceForPaymentProxy> {

    @Path("number")
    TextField getNumberField();

    @Path("date")
    DateField getDateField();

    @Path("supplier")
    SupplierField getSupplierField();

    @Path("priceSum")
    DoubleField getPriceSumField();
}
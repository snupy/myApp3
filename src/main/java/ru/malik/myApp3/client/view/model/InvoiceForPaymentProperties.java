package ru.malik.myApp3.client.view.model;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import ru.malik.myApp3.client.request.proxy.InvoiceForPaymentProxy;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;

import java.util.Date;

/**
 * Created by Малик on 14.12.2014.
 */
public interface InvoiceForPaymentProperties extends PropertyAccess<InvoiceForPaymentProxy> {
    @Editor.Path("id")
    ModelKeyProvider<InvoiceForPaymentProxy> id();

    @Editor.Path("date")
    ValueProvider<InvoiceForPaymentProxy, Date> date();

    @Editor.Path("number")
    ValueProvider<InvoiceForPaymentProxy, String> number();

    @Editor.Path("supplier.name")
    ValueProvider<InvoiceForPaymentProxy, String> supplier();

    @Editor.Path("priceSum")
    ValueProvider<InvoiceForPaymentProxy, Double> priceSum();
}

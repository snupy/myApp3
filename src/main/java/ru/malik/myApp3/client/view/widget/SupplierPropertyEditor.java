package ru.malik.myApp3.client.view.widget;

import com.sencha.gxt.widget.core.client.form.PropertyEditor;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;

import java.text.ParseException;

/**
 * Created by Зуфар on 19.12.2014.
 */
public class SupplierPropertyEditor extends PropertyEditor<SupplierProxy> {
    @Override
    public SupplierProxy parse(CharSequence charSequence) throws ParseException {
        return null;
    }

    @Override
    public String render(SupplierProxy supplierProxy) {
        return supplierProxy.getName();
    }
}

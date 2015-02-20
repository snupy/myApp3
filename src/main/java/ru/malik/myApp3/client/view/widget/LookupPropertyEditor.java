package ru.malik.myApp3.client.view.widget;

import com.sencha.gxt.widget.core.client.form.PropertyEditor;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;

import java.text.ParseException;

/**
 * Created by Зуфар on 19.12.2014.
 */
public abstract class LookupPropertyEditor<E> extends PropertyEditor<E> {
    @Override
    public E parse(CharSequence charSequence) throws ParseException {
        return null;
    }


}

package ru.malik.myApp3.client.view;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.widget.core.client.form.TextField;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;

/**
 * Created by Малик on 31.12.2014.
 */
public interface SupplierEditor extends Editor<SupplierProxy>{
    @Path("name")
    public TextField getNameField();
}

package ru.malik.myApp3.client.view.model;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;

/**
 * Created by Малик on 09.11.2014.
 */
public interface SupplierProxyProperties extends PropertyAccess<SupplierProxy> {
    @Editor.Path("id")
    ModelKeyProvider<SupplierProxy> id();

    @Editor.Path("name")
    ValueProvider<SupplierProxy, String> name();

}

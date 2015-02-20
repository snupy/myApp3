package ru.malik.myApp3.client.view;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.widget.core.client.form.TextField;
import ru.malik.myApp3.client.request.proxy.BuildingProjectProxy;

/**
 * Created by Малик on 05.01.2015.
 */
public interface BuildingProjectEditor extends Editor<BuildingProjectProxy> {
    @Path("name")
    TextField getNameField();
}

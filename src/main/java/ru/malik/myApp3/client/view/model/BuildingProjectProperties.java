package ru.malik.myApp3.client.view.model;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import ru.malik.myApp3.client.request.proxy.BuildingProjectProxy;

/**
 * Created by Зуфар on 23.12.2014.
 */
public interface BuildingProjectProperties extends PropertyAccess<BuildingProjectProxy> {
    @Editor.Path("id")
    ModelKeyProvider<BuildingProjectProxy> id();

    @Editor.Path("name")
    ValueProvider<BuildingProjectProxy, String> name();
}

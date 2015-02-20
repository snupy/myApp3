package ru.malik.myApp3.client.view.widget;

import com.sencha.gxt.cell.core.client.form.TwinTriggerFieldCell;
import com.sencha.gxt.widget.core.client.form.PropertyEditor;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;

/**
 * Created by Зуфар on 19.12.2014.
 */
public class LookupCell<E> extends TwinTriggerFieldCell<E> {
    public LookupCell(TwinTriggerFieldAppearance appearance, PropertyEditor<E> editor) {
        super(appearance);

        setPropertyEditor(editor);
    }

}

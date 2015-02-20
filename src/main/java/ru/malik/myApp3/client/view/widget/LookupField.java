package ru.malik.myApp3.client.view.widget;

import com.sencha.gxt.cell.core.client.form.TwinTriggerFieldCell;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent;
import com.sencha.gxt.widget.core.client.event.TwinTriggerClickEvent;
import com.sencha.gxt.widget.core.client.form.PropertyEditor;
import com.sencha.gxt.widget.core.client.form.TwinTriggerField;
import ru.malik.myApp3.client.ClientFactory;
import ru.malik.myApp3.client.event.SelectEvent;
import ru.malik.myApp3.client.presenter.SupplierSelectDialogPresenterImpl;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;

/**
 * Created by Зуфар on 19.12.2014.
 */
public class LookupField<E> extends TwinTriggerField<E> {
    protected LookupField(TwinTriggerFieldCell<E> cell, PropertyEditor<E> propertyEditor) {
        super(cell, propertyEditor);
    }

    protected LookupField(TwinTriggerFieldCell<E> cell) {
        this(cell, cell.getPropertyEditor());
    }

    public LookupField(PropertyEditor<E> propertyEditor) {
        this(new LookupCell<E>(new LookupAppear(), propertyEditor));
    }
}

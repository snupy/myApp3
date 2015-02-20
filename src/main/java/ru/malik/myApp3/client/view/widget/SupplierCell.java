package ru.malik.myApp3.client.view.widget;

import com.sencha.gxt.cell.core.client.form.TwinTriggerFieldCell;
import ru.malik.myApp3.client.request.proxy.SupplierProxy;

/**
 * Created by Зуфар on 19.12.2014.
 */
public class SupplierCell extends TwinTriggerFieldCell<SupplierProxy> {
    public SupplierCell(TwinTriggerFieldAppearance appearance) {
        super(appearance);

        setPropertyEditor(new SupplierPropertyEditor());
    }

}

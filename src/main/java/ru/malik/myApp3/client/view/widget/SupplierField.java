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
public class SupplierField extends TwinTriggerField<SupplierProxy>{
    protected SupplierField(TwinTriggerFieldCell<SupplierProxy> cell, PropertyEditor<SupplierProxy> propertyEditor) {
        super(cell, propertyEditor);
    }

    private HasSupplier hasSupplier;
    private SupplierSelectDialogPresenterImpl supplierSelectDialogPresenter;

    protected SupplierField(TwinTriggerFieldCell<SupplierProxy> cell){
        this(cell, cell.getPropertyEditor());

        addTwinTriggerClickHandler(new TwinTriggerClickEvent.TwinTriggerClickHandler() {
            @Override
            public void onTwinTriggerClick(TwinTriggerClickEvent twinTriggerClickEvent) {
                SupplierField.this.supplierSelectDialogPresenter.show();
            }
        });

        addTriggerClickHandler(new TriggerClickEvent.TriggerClickHandler() {
            @Override
            public void onTriggerClick(TriggerClickEvent triggerClickEvent) {

            }
        });


    }


    public SupplierField(){
        this(new SupplierCell(new SupplierAppear()));
    }

    public void setHasSupplier(HasSupplier hasSupplier){
        this.hasSupplier = hasSupplier;
    }

    public void setClientFactory(ClientFactory clientFactory){
        supplierSelectDialogPresenter = new SupplierSelectDialogPresenterImpl(clientFactory);
        supplierSelectDialogPresenter.addSelectHandlers(
                new SelectEvent.SelectHandler() {
                    @Override
                    public void onSelect(SelectEvent selectEvent) {
                        SupplierField.this.setValue((SupplierProxy)selectEvent.getSelection());
                    }
                }
        /*new OkEvent.OkHandler() {
            @Override
            public void onSave(OkEvent selectEvent) {
                SupplierField.this.setValue(supplierSelectDialogPresenter.getSupplier());
            }
        }*/);
    }

}

package ru.malik.myApp3.client.view.dialogs;

import com.google.gwt.user.client.ui.HasWidgets;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

/**
 * Created by Малик on 30.11.2014.
 */
public class EditDialog extends Window implements HasWidgets {
    private TextButton saveBtn = new TextButton("Сохранить"), cancelBtn = new TextButton("Отмена");
    private boolean closeOnOk = true;
    private boolean closeOnCancel = true;

    public EditDialog() {
        super();
        addButton(saveBtn);
        addButton(cancelBtn);

        saveBtn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                onSave();
            }
        });

        cancelBtn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                onCancel();
            }
        });
    }


    public void onSave() {
        if (closeOnOk) hide();
    }

    public void onCancel() {
        if (closeOnCancel) hide();
    }
}

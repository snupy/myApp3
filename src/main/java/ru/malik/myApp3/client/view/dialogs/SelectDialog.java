package ru.malik.myApp3.client.view.dialogs;

import com.google.gwt.user.client.ui.HasWidgets;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

/**
 * Created by Зуфар on 20.12.2014.
 */
public class SelectDialog extends Window implements HasWidgets {
    private TextButton selectBtn = new TextButton("Выбрать"), cancelBtn = new TextButton("Отмена");
    private boolean closeOnOk = true;
    private boolean closeOnCancel = true;

    public SelectDialog() {
        super();
        addButton(selectBtn);
        addButton(cancelBtn);

        selectBtn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                onOk();
            }
        });

        cancelBtn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                onCancel();
            }
        });
    }


    public void onOk() {
        if (closeOnCancel) hide();
    }

    public void onCancel() {
        if (closeOnCancel)
            hide();
    }
}

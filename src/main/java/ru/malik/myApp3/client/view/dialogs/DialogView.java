package ru.malik.myApp3.client.view.dialogs;

import com.google.gwt.user.client.ui.IsWidget;
import ru.malik.myApp3.client.presenter.Presenter;
import ru.malik.myApp3.client.view.View;

/**
 * Created by Малик on 31.12.2014.
 */
public interface DialogView<P extends Presenter> extends IsWidget, View<P> {
    public void setContent(IsWidget widget);

    public void show();

    public void hide();
}

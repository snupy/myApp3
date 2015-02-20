package ru.malik.myApp3.client.presenter;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import ru.malik.myApp3.client.ClientFactory;

/**
 * Created by Малик on 31.12.2014.
 */
public abstract class AbstractListViewPresenter<V, E> implements ListViewPresenter<V, E> {

    E selectedItem;

    @Override
    public void fireEvent(GwtEvent<?> event) {
        getClientFactory().getEventBus().fireEvent(event);
    }

    @Override
    public HandlerRegistration addSelectionHandler(SelectionHandler<E> handler) {
        return getClientFactory().getEventBus().addHandler(SelectionEvent.getType(), handler);
    }

    @Override
    public E getSelectItem() {
        return selectedItem;
    }

    @Override
    public void selectItem(E obj) {
        selectedItem = obj;
    }
}

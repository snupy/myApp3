package ru.malik.myApp3.client.presenter;

import com.google.gwt.event.logical.shared.HasSelectionHandlers;

import java.util.List;

/**
 * Created by Малик on 31.12.2014.
 */
public interface ListViewPresenter<V, E> extends Presenter<V>, HasSelectionHandlers<E> {
    void addItem();
    void deleteItem(List<E> list);
    void editItem(E obj);
    void selectItem(E obj);
    E getSelectItem();
}

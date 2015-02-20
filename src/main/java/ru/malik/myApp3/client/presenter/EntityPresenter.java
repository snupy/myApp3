package ru.malik.myApp3.client.presenter;

/**
 * Created by Малик on 31.12.2014.
 */
public interface EntityPresenter<V,E,R> extends Presenter<V> {
    public void edit(E obj, R request);
    public void save();
}

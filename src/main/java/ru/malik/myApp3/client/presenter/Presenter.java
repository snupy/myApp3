package ru.malik.myApp3.client.presenter;

import ru.malik.myApp3.client.ClientFactory;

/**
 * Created by Малик on 31.12.2014.
 */
public interface Presenter<V> {
    public V getView();
    public ClientFactory getClientFactory();
}

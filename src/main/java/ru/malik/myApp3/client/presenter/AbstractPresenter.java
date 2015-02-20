package ru.malik.myApp3.client.presenter;

import ru.malik.myApp3.client.ClientFactory;

/**
 * Created by Малик on 31.12.2014.
 */
public abstract class AbstractPresenter<V> implements Presenter<V> {

    protected V view;
    private ClientFactory clientFactory;

    @Override
    public V getView() {
        return view;
    }

    @Override
    public ClientFactory getClientFactory() {
        return this.clientFactory;
    }

    protected AbstractPresenter(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
}

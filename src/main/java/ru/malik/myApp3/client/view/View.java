package ru.malik.myApp3.client.view;

import ru.malik.myApp3.client.presenter.Presenter;

/**
 * Created by Малик on 31.12.2014.
 */
public interface View<P extends Presenter>{
    public void setPresenter(P presenter);
    public P getPresenter();
}

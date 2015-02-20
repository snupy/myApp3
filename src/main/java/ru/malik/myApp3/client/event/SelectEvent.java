package ru.malik.myApp3.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Created by Малик on 30.11.2014.
 */
public class SelectEvent<T> extends GwtEvent<SelectEvent.SelectHandler>{

    public static interface SelectHandler extends EventHandler {
        void onSelect(SelectEvent selectEvent);
    }

    public static interface HasSelectHandlers {
        HandlerRegistration addSelectHandlers(SelectHandler selectHandler);
    }

    public static final Type<SelectHandler> TYPE = new Type<SelectHandler>();

    private T selection;

    public T getSelection(){
        return selection;
    }

    @Override
    public Type<SelectHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(SelectHandler handler) {
        handler.onSelect(this);
    }

    public SelectEvent(T selection) {
        this.selection = selection;
    }
}

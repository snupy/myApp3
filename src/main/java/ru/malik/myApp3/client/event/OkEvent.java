package ru.malik.myApp3.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Created by Малик on 30.11.2014.
 */
public class OkEvent extends GwtEvent<OkEvent.OkHandler>{
    public static final Type<OkHandler> TYPE = new Type<OkHandler>();

    @Override
    public Type<OkHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(OkHandler handler) {
        handler.onSave(this);
    }

    public static interface OkHandler extends EventHandler {
        void onSave(OkEvent saveEvent);
    }

    public static interface HasOkHandlers{
        HandlerRegistration addOkHandlers(OkHandler okHandler);
    }
}

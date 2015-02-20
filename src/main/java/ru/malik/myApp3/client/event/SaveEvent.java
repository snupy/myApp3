package ru.malik.myApp3.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Created by Малик on 30.11.2014.
 */
public class SaveEvent extends GwtEvent<SaveEvent.SaveHandler>{
    public static final Type<SaveHandler> TYPE = new Type<SaveHandler>();

    @Override
    public Type<SaveHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(SaveHandler handler) {
        handler.onSave(this);
    }

    public static interface SaveHandler extends EventHandler {
        void onSave(SaveEvent saveEvent);
    }

    public static interface HasSaveHandlers{
        HandlerRegistration addSaveHandlers(SaveHandler saveHandler);
    }
}

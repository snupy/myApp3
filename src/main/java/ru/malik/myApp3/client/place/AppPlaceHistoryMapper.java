package ru.malik.myApp3.client.place;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import ru.malik.myApp3.client.view.SupplierView;

/**
 * Created by Малик on 04.11.2014.
 */
@WithTokenizers({InvoceForPaymentListPlace.Tokenizer.class, SuppliersListPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}

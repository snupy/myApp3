package ru.malik.myApp3.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by Малик on 09.11.2014.
 */
public class InvoceForPaymentListPlace extends Place {
    public static class Tokenizer implements PlaceTokenizer<InvoceForPaymentListPlace> {
        @Override
        public String getToken(InvoceForPaymentListPlace place) {
            return "";
        }

        @Override
        public InvoceForPaymentListPlace getPlace(String token) {
            return new InvoceForPaymentListPlace();
        }
    }
}

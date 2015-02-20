package ru.malik.myApp3.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by Малик on 09.11.2014.
 */
public class SuppliersListPlace extends Place {
    public static class Tokenizer implements PlaceTokenizer<SuppliersListPlace> {
        @Override
        public String getToken(SuppliersListPlace place) {
            return "";
        }

        @Override
        public SuppliersListPlace getPlace(String token) {
            return new SuppliersListPlace();
        }
    }
}

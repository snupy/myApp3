package ru.malik.myApp3.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by Зуфар on 23.12.2014.
 */
public class BuildingProjectListPlace extends Place{
    public static class Tokenizer implements PlaceTokenizer<BuildingProjectListPlace> {
        @Override
        public String getToken(BuildingProjectListPlace place) {
            return "";
        }

        @Override
        public BuildingProjectListPlace getPlace(String token) {
            return new BuildingProjectListPlace();
        }
    }
}

package com.lsilencej.sunnyweather.logic.dao;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.lsilencej.sunnyweather.SunnyWeatherApplication;
import com.lsilencej.sunnyweather.logic.model.PlaceResponse.Place;

public class PlaceDao {

    private static SharedPreferences sharedPreferences = SunnyWeatherApplication.getContext().getSharedPreferences("sunny_weather", Context.MODE_PRIVATE);

    public static void savePlace(Place place) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("place", new Gson().toJson(place));
        editor.apply();
    }

    public static Place getSavedPlace() {
        String placeJson = sharedPreferences.getString("place", "");
        return new Gson().fromJson(placeJson, Place.class);
    }

    public static Boolean isPlaceSaved() {
        return sharedPreferences.contains("place");
    }

}

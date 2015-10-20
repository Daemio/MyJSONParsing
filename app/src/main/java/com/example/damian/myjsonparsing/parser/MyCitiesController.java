package com.example.damian.myjsonparsing.parser;

import android.util.Log;

import com.example.damian.myjsonparsing.model.Countries;
import com.example.damian.myjsonparsing.model.UserData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 19.10.2015.
 */
public class MyCitiesController {

    private static <T> T getModel(String value, Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (IOException e) {
            Log.e("", "Can't read value from mapped data", e);
            return null;
        }
    }

    public static List<UserData> getAllCities(String json) {
        Countries data;
        data = getModel(json, Countries.class);
        return Arrays.asList(data.getCities());
    }
}

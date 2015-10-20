package com.example.damian.myjsonparsing.remote;

import com.example.damian.myjsonparsing.model.Cities;


import retrofit.http.GET;

/**
 * Created by Admin on 20.10.2015.
 */
public interface IService {
    @GET("/query_cities")
    Cities getCities();
}

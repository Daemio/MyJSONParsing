package com.example.damian.myjsonparsing.handler;

import android.os.AsyncTask;
import android.util.Log;

import com.example.damian.myjsonparsing.database.DatabaseGateway;
import com.example.damian.myjsonparsing.event.ICallback;
import com.example.damian.myjsonparsing.model.UserData;
import com.example.damian.myjsonparsing.remote.service.CitiesService;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit.RetrofitError;

/**
 * Created by Admin on 20.10.2015.
 */
public class CitiesHandler extends AsyncTask<Void,Void, List<UserData>>{

    private ICallback callback;
    private CitiesService service;
    public CitiesHandler(ICallback callback, CitiesService service) {
        this.callback = callback;
        this.service = service;
    }

    @Override
    protected void onPreExecute() {
        if (callback!=null){
            callback.onStart();
        }
    }

    @Override
    protected List<UserData> doInBackground(Void... params) {
        List<UserData> cities = null;
        try {
            cities = service.run().getCities().getCities();
            try {
                DatabaseGateway.insertCities(cities);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (RetrofitError error){
           // cities = HelperFactory.getHelper().getUserDataDAO().getAllCities();
            if(callback!=null) {
                callback.onError("Failed to connect to server, data taken from local DB");
            }

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                cities = DatabaseGateway.getAllCities();
                //Log.d("mytag", ""+cities.size());
            } catch (SQLException e) {
                if (callback!=null){
                    callback.onError(error.toString());
                }
            }

        }
        //Log.d("mytag", ""+cities.size());
        return cities;
    }

    @Override
    protected void onPostExecute(List<UserData> cities) {
      if (callback!= null){
          if (cities!=null){
              callback.onSuccess(cities);
          }
          callback.onFinish();
      }
    }
}

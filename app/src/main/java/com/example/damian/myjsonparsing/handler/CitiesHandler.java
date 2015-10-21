package com.example.damian.myjsonparsing.handler;

import android.os.AsyncTask;

import com.example.damian.myjsonparsing.database.DatabaseHelper;
import com.example.damian.myjsonparsing.database.HelperFactory;
import com.example.damian.myjsonparsing.event.ICallback;
import com.example.damian.myjsonparsing.model.Cities;
import com.example.damian.myjsonparsing.remote.service.CitiesService;

import retrofit.RetrofitError;

/**
 * Created by Admin on 20.10.2015.
 */
public class CitiesHandler extends AsyncTask<Void,Void, Cities>{

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
    protected Cities doInBackground(Void... params) {
        Cities cities = null;
        try {
            cities = service.run().getCities();
        }catch (RetrofitError error){
           // cities = HelperFactory.getHelper().getUserDataDAO().getAllCities();
            if (callback!=null){
                callback.onError(error.toString());
            }
        }
        return cities;
    }

    @Override
    protected void onPostExecute(Cities cities) {
      if (callback!= null){
          if (cities!=null){
              callback.onSuccess(cities);
          }
          callback.onFinish();
      }
    }
}

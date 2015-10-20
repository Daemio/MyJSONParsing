package com.example.damian.myjsonparsing;

import android.os.AsyncTask;

import com.example.damian.myjsonparsing.event.ICallback;
import com.example.damian.myjsonparsing.handler.CitiesHandler;
import com.example.damian.myjsonparsing.remote.service.CitiesService;

/**
 * Created by Admin on 20.10.2015.
 */
public class RemoteManager {
    public static void getCities(ICallback callback) {
        new CitiesHandler(callback, new CitiesService()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}

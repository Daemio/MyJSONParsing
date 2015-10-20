package com.example.damian.myjsonparsing.event;

import com.example.damian.myjsonparsing.model.Cities;

/**
 * Created by Admin on 20.10.2015.
 */
public interface ICallback {
    void onStart();
    void onSuccess(Cities cities);
    void onError(String cause);
    void onFinish();
}

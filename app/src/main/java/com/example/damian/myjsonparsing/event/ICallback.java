package com.example.damian.myjsonparsing.event;

import com.example.damian.myjsonparsing.model.Cities;
import com.example.damian.myjsonparsing.model.UserData;

import java.util.List;

/**
 * Created by Admin on 20.10.2015.
 */
public interface ICallback {
    void onStart();
    void onSuccess(List<UserData> cities);
    void onError(String cause);
    void onFinish();
}

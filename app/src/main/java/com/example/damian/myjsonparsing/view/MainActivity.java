package com.example.damian.myjsonparsing.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.damian.myjsonparsing.R;
import com.example.damian.myjsonparsing.RemoteManager;
import com.example.damian.myjsonparsing.event.ICallback;
import com.example.damian.myjsonparsing.model.Cities;
import com.example.damian.myjsonparsing.model.UserData;
import com.example.damian.myjsonparsing.view.adapter.MyArrayAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<UserData> data;
    MyArrayAdapter adapter;
    ListView lvMain;
    String json; //our json String

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMain = (ListView) findViewById(R.id.lvMain);

        //test array adapter
        /*
        data = new ArrayList<UserData>();
        data.add(new UserData("Simferopol",12.443,234.435,"1.2",1));
        data.add(new UserData("Moscow",32.4533,123.54335,"1.2",1));
        data.add(new UserData("Barnaul",45.2443,234.225,"1.2",1));
        data.add(new UserData("Paris",54.233,234.6535,"1.2",1));
        data.add(new UserData("London",87.533,234.2435,"1.2",1));
        */

        //data = MyCitiesController.getAllCities(Utils.ReadFromfile("cities.json",getApplicationContext()));
        adapter = new MyArrayAdapter(this, R.layout.item);
        lvMain.setAdapter(adapter);


        RemoteManager.getCities(new ICallback() {
            @Override
            public void onStart() {
                Toast.makeText(MainActivity.this, "onStart", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onSuccess(Cities cities) {
                adapter.clear();
                adapter.addAll(cities.getCities());
                Toast.makeText(MainActivity.this, "onSuccess", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String cause) {
                Toast.makeText(MainActivity.this, cause, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "onFinish", Toast.LENGTH_LONG).show();
            }
        });
    }
}

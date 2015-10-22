package com.example.damian.myjsonparsing.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.damian.myjsonparsing.R;
import com.example.damian.myjsonparsing.RemoteManager;
import com.example.damian.myjsonparsing.database.DatabaseGateway;
import com.example.damian.myjsonparsing.event.ICallback;
import com.example.damian.myjsonparsing.model.Cities;
import com.example.damian.myjsonparsing.model.UserData;
import com.example.damian.myjsonparsing.view.adapter.MyArrayAdapter;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<UserData> data;
    MyArrayAdapter adapter;
    ListView lvMain;
    String json; //our json String
    RelativeLayout progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_full);
        lvMain = (ListView) findViewById(R.id.lvMain);
        progressBar = (RelativeLayout) findViewById(R.id.loadingPanel);

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
        adapter = new MyArrayAdapter(this, R.layout.item_full);
        lvMain.setAdapter(adapter);


        RemoteManager.getCities(new ICallback() {
            @Override
            public void onStart() {
                Toast.makeText(MainActivity.this, "onStart", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSuccess(List<UserData> cities) {
                adapter.clear();
                adapter.addAll(cities);
                Toast.makeText(MainActivity.this, "onSuccess", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String cause) {

            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "onFinish", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}

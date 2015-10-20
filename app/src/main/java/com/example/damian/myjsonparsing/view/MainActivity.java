package com.example.damian.myjsonparsing.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.damian.myjsonparsing.R;
import com.example.damian.myjsonparsing.Utils;
import com.example.damian.myjsonparsing.model.UserData;
import com.example.damian.myjsonparsing.parser.MyCitiesController;
import com.example.damian.myjsonparsing.view.adapter.MyArrayAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<UserData> data;
    MyArrayAdapter adapter;
    ListView lvMain;

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
        data = MyCitiesController.getAllCities(Utils.MY_JSON);
        adapter = new MyArrayAdapter(this, R.layout.item);
        lvMain.setAdapter(adapter);
        adapter.addAll(data);

    }


}

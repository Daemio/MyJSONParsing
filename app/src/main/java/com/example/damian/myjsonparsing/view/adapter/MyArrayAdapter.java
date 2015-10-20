package com.example.damian.myjsonparsing.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.damian.myjsonparsing.R;
import com.example.damian.myjsonparsing.model.UserData;

/**
 * Created by Admin on 19.10.2015.
 */
public class MyArrayAdapter extends ArrayAdapter<UserData>{

    public MyArrayAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class ViewHolder{
        TextView tvName;
        TextView tvLatitude;
        TextView tvLongitude;
        TextView tvAppVersion;
        TextView tvEconom;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;
        if(v==null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.item,null);
            holder = new ViewHolder();
            holder.tvName = (TextView) v.findViewById(R.id.tvName);
            holder.tvLatitude = (TextView) v.findViewById(R.id.tvLatitude);
            holder.tvLongitude = (TextView) v.findViewById(R.id.tvLongitude);
            holder.tvAppVersion = (TextView) v.findViewById(R.id.tvAppVersion);
            holder.tvEconom = (TextView) v.findViewById(R.id.tvEconom);
            v.setTag(holder);
        }else{
            holder = (ViewHolder) v.getTag();
        }

        UserData item = (UserData) getItem(position);
        holder.tvName.setText(item.getName());
        holder.tvLatitude.setText(String.format("%.4f", item.getLatitude()));
        holder.tvLongitude.setText(String.format("%.4f", item.getLongitude()));
        holder.tvAppVersion.setText(item.getLastAppVersion());
        holder.tvEconom.setText(""+item.getEconom());
        return v;
    }
}

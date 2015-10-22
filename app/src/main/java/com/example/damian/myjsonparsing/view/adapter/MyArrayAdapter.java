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
        TextView tvId;
        TextView tvName;
        TextView tvApiUrl;
        TextView tvDomain;
        TextView tvMobileServer;
        TextView tvDocUrl;
        TextView tvLatitude;
        TextView tvLongitude;
        TextView tvSpnLatitude;
        TextView tvSpnLongitude;
        TextView tvAppVersion;
        TextView tvDriverApkLink;
        TextView tvPayMethods;
        TextView tvTransfers;
        TextView tvEconom;
        TextView tvEconomTime;
        TextView tvRegPromocode;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;
        if(v==null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.item_full,null);
            holder = new ViewHolder();
            holder.tvId = (TextView) v.findViewById(R.id.tvId);
            holder.tvName = (TextView) v.findViewById(R.id.tvName);
            holder.tvApiUrl = (TextView) v.findViewById(R.id.tvApiUrl);
            holder.tvDomain = (TextView) v.findViewById(R.id.tvDomain);
            holder.tvMobileServer = (TextView) v.findViewById(R.id.tvMobileServer);
            holder.tvDocUrl = (TextView) v.findViewById(R.id.tvDocUrl);
            holder.tvLatitude = (TextView) v.findViewById(R.id.tvLatitude);
            holder.tvLongitude = (TextView) v.findViewById(R.id.tvLongitude);
            holder.tvSpnLatitude = (TextView) v.findViewById(R.id.tvSpnLatitude);
            holder.tvSpnLongitude = (TextView) v.findViewById(R.id.tvSpnLongitude);
            holder.tvAppVersion = (TextView) v.findViewById(R.id.tvAppVersion);
            holder.tvDriverApkLink = (TextView) v.findViewById(R.id.tvDriverApkLink);
            holder.tvPayMethods = (TextView) v.findViewById(R.id.tvPayMethods);
            holder.tvTransfers = (TextView) v.findViewById(R.id.tvTransfers);
            holder.tvEconom = (TextView) v.findViewById(R.id.tvEconom);
            holder.tvEconomTime = (TextView) v.findViewById(R.id.tvEconomTime);
            holder.tvRegPromocode = (TextView) v.findViewById(R.id.tvRegPromocode);
            v.setTag(holder);
        }else{
            holder = (ViewHolder) v.getTag();
        }

        UserData item = (UserData) getItem(position);
        holder.tvId.setText(""+item.getId());
        holder.tvName.setText(item.getName());
        holder.tvApiUrl.setText(item.getApiUrl());
        holder.tvDomain.setText(item.getDomain());
        holder.tvMobileServer.setText(item.getMobileServer());
        holder.tvDocUrl.setText(item.getDocUrl());
        holder.tvLatitude.setText(String.format("%.4f", item.getLatitude()));
        holder.tvLongitude.setText(String.format("%.4f", item.getLongitude()));
        holder.tvSpnLatitude.setText(String.format("%.4f", item.getSpnLatitude()));
        holder.tvSpnLongitude.setText(String.format("%.4f", item.getSpnLongitude()));
        holder.tvAppVersion.setText(item.getLastAppVersion());
        holder.tvDriverApkLink.setText(item.getAndroidDriverApkLink());
        String s[] = item.getInappPayMethods();
        if(s == null){
            holder.tvPayMethods.setText("none");
        }else{
            String str = "";
            for(int i = 0;i<s.length - 1;i++){
                str += s[i] + ",";
            }
            str += s[s.length -1];
            holder.tvPayMethods.setText(str);
        }
        holder.tvTransfers.setText(item.isTransfers() ? "true":"false");
        holder.tvEconom.setText(""+item.getEconom());
        holder.tvEconomTime.setText(""+item.getEconomTime());
        holder.tvRegPromocode.setText(item.isRegistrationPromoode() ? "true":"false");
        return v;
    }
}

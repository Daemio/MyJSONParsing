package com.example.damian.myjsonparsing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Admin on 19.10.2015.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
@DatabaseTable(tableName = "cities")
public class UserData {
    @JsonProperty("city_id")
    @DatabaseField(id = true)
    int id;
    @JsonProperty("city_name")
    @DatabaseField(dataType = DataType.STRING)
    String name;
    @JsonProperty("city_api_url")
    @DatabaseField(dataType = DataType.STRING)
    String apiUrl;
    @JsonProperty("city_domain")
    @DatabaseField(dataType = DataType.STRING)
    String domain;
    @JsonProperty("city_mobile_server")
    @DatabaseField(dataType = DataType.STRING)
    String mobileServer;
    @JsonProperty( "city_doc_url")
    @DatabaseField(dataType = DataType.STRING)
    String docUrl;
    @JsonProperty("city_latitude")
    @DatabaseField(dataType = DataType.DOUBLE)
    double latitude;
    @JsonProperty("city_longitude")
    @DatabaseField(dataType = DataType.DOUBLE)
    double longitude;
    @JsonProperty("city_spn_latitude")
    @DatabaseField(dataType = DataType.DOUBLE)
    double spnLatitude;
    @JsonProperty("city_spn_longitude")
    @DatabaseField(dataType = DataType.DOUBLE)
    double spnLongitude;
    @JsonProperty("last_app_android_version")
    @DatabaseField(dataType = DataType.STRING)
    String lastAppVersion;
    @JsonProperty("android_driver_apk_link")
    @DatabaseField(dataType = DataType.STRING)
    String androidDriverApkLink;
    @JsonProperty("inapp_pay_methods")
    @DatabaseField(dataType = DataType.SERIALIZABLE) //is it ok?
    String[] inappPayMethods;
    @JsonProperty("transfers")
    @DatabaseField(dataType = DataType.BOOLEAN)
    boolean transfers;
    @JsonProperty("experimental_econom_plus")
    @DatabaseField(dataType = DataType.INTEGER)
    int econom;
    @JsonProperty("experimental_econom_plus_time")
    @DatabaseField(dataType = DataType.INTEGER)
    int economTime;
    @JsonProperty("registration_promocode")
    @DatabaseField(dataType = DataType.BOOLEAN)
    boolean registrationPromoode;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getDomain() {
        return domain;
    }

    public String getMobileServer() {
        return mobileServer;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getSpnLatitude() {
        return spnLatitude;
    }

    public Double getSpnLongitude() {
        return spnLongitude;
    }

    public String getLastAppVersion() {
        return lastAppVersion;
    }

    public String getAndroidDriverApkLink() {
        return androidDriverApkLink;
    }

    public String[] getInappPayMethods() {
        return inappPayMethods;
    }

    public boolean isTransfers() {
        return transfers;
    }

    public int getEconom() {
        return econom;
    }

    public int getEconomTime() {
        return economTime;
    }

    public boolean isRegistrationPromoode() {
        return registrationPromoode;
    }
}

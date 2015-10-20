package com.example.damian.myjsonparsing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Admin on 19.10.2015.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class UserData {
    @JsonProperty("city_id")
    int id;
    @JsonProperty("city_name")
    String name;
    @JsonProperty("city_api_url")
    String apiUrl;
    @JsonProperty("city_domain")
    String domain;
    @JsonProperty("city_mobile_server")
    String mobileServer;
    @JsonProperty( "city_doc_url")
    String docUrl;
    @JsonProperty("city_latitude")
    Double latitude;
    @JsonProperty("city_longitude")
    Double longitude;
    @JsonProperty("city_spn_latitude")
    Double spnLatitude;
    @JsonProperty("city_spn_longitude")
    Double spnLongitude;
    @JsonProperty("last_app_android_version")
    String lastAppVersion;
    @JsonProperty("android_driver_apk_link")
    String androidDriverApkLink;
    @JsonProperty("inapp_pay_methods")
    String[] inappPayMethods;
    @JsonProperty("transfers")
    boolean transfers;
    @JsonProperty("experimental_econom_plus")
    int econom;
    @JsonProperty("experimental_econom_plus_time")
    int economTime;
    @JsonProperty("registration_promocode")
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

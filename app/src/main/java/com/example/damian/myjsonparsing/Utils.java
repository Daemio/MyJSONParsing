package com.example.damian.myjsonparsing;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Admin on 19.10.2015.
 */
public class Utils {
    public static String MY_JSON = "{\"cities\":[{\"city_id\":1,\"city_name\":\"Москва\",\"city_api_url\":\"http:\\/\\/beta.taxistock.ru\\/taxik\\/api\\/client\\/\",\"city_domain\":\"beta.taxistock.ru\",\"city_mobile_server\":\"protobuf.taxistock.ru:7777\",\"city_doc_url\":\"http:\\/\\/beta.taxistock.ru\\/taxik\\/api\\/doc\\/\",\"city_latitude\":55.755773,\"city_longitude\":37.617761,\"city_spn_latitude\":0.964953,\"city_spn_longitude\":2.757568,\"last_app_android_version\":7045,\"android_driver_apk_link\":\"http:\\/\\/www.taxik.ru\\/a\\/taxik.apk\",\"inapp_pay_methods\":[\"chronopay\"],\"transfers\":true,\"experimental_econom_plus\":5,\"experimental_econom_plus_time\":40,\"registration_promocode\":true},{\"city_id\":2,\"city_name\":\"Санкт-Петербург\",\"city_api_url\":\"http:\\/\\/piter.beta.taxistock.ru\\/taxik\\/api\\/client\\/\",\"city_domain\":\"piter.beta.taxistock.ru\",\"city_mobile_server\":\"protobuf.taxistock.ru:7788\",\"city_doc_url\":\"http:\\/\\/piter.beta.taxistock.ru\\/taxik\\/api\\/doc\\/\",\"city_latitude\":59.993492,\"city_longitude\":30.289062,\"city_spn_latitude\":0.840364,\"city_spn_longitude\":3.013,\"last_app_android_version\":7045,\"android_driver_apk_link\":\"http:\\/\\/www.taxik.ru\\/a\\/taxik.apk\",\"transfers\":false},{\"city_id\":3,\"city_name\":\"Воронеж\",\"city_api_url\":\"http:\\/\\/voronezh.beta.taxistock.ru\\/taxik\\/api\\/client\\/\",\"city_domain\":\"voronezh.beta.taxistock.ru\",\"city_mobile_server\":\"protobuf.taxistock.ru:7789\",\"city_doc_url\":\"http:\\/\\/voronezh.beta.taxistock.ru\\/taxik\\/api\\/doc\\/\",\"city_latitude\":51.683415,\"city_longitude\":39.182638,\"city_spn_latitude\":0.130182,\"city_spn_longitude\":0.376625,\"last_app_android_version\":7045,\"android_driver_apk_link\":\"http:\\/\\/www.taxik.ru\\/a\\/taxik.apk\",\"transfers\":false},{\"city_id\":4,\"city_name\":\"Ростов-на-Дону\",\"city_api_url\":\"http:\\/\\/rostov.beta.taxistock.ru\\/taxik\\/api\\/client\\/\",\"city_domain\":\"rostov.beta.taxistock.ru\",\"city_mobile_server\":\"protobuf.taxistock.ru:7790\",\"city_doc_url\":\"http:\\/\\/rostov.beta.taxistock.ru\\/taxik\\/api\\/doc\\/\",\"city_latitude\":57.19223,\"city_longitude\":39.418317,\"city_spn_latitude\":0.056843,\"city_spn_longitude\":0.188313,\"last_app_android_version\":7045,\"android_driver_apk_link\":\"http:\\/\\/www.taxik.ru\\/a\\/taxik.apk\",\"transfers\":false},{\"city_id\":5,\"city_name\":\"Уфа\",\"city_api_url\":\"http:\\/\\/ufa.beta.taxistock.ru\\/taxik\\/api\\/client\\/\",\"city_domain\":\"ufa.beta.taxistock.ru\",\"city_mobile_server\":\"protobuf.taxistock.ru:7791\",\"city_doc_url\":\"http:\\/\\/ufa.beta.taxistock.ru\\/taxik\\/api\\/doc\\/\",\"city_latitude\":54.738412,\"city_longitude\":55.983461,\"city_spn_latitude\":0.559397,\"city_spn_longitude\":1.216736,\"last_app_android_version\":7045,\"android_driver_apk_link\":\"http:\\/\\/www.taxik.ru\\/a\\/taxik.apk\",\"transfers\":false},{\"city_id\":9,\"city_name\":\"Шахты\",\"parent_city\":4,\"city_api_url\":\"http:\\/\\/rostov.beta.taxistock.ru\\/taxik\\/api\\/client\\/\",\"city_domain\":\"rostov.beta.taxistock.ru\",\"city_mobile_server\":\"protobuf.taxistock.ru:7790\",\"city_doc_url\":\"http:\\/\\/rostov.beta.taxistock.ru\\/taxik\\/api\\/doc\\/\",\"city_latitude\":47.708485,\"city_longitude\":40.215958,\"city_spn_latitude\":0.097761,\"city_spn_longitude\":0.197258,\"last_app_android_version\":7045,\"android_driver_apk_link\":\"http:\\/\\/www.taxik.ru\\/a\\/taxik.apk\",\"transfers\":false},{\"city_id\":10,\"city_name\":\"Рязань\",\"city_api_url\":\"http:\\/\\/ryazan.beta.taxistock.ru\\/taxik\\/api\\/client\\/\",\"city_domain\":\"ryazan.beta.taxistock.ru\",\"city_mobile_server\":\"protobuf.taxistock.ru:7795\",\"city_doc_url\":\"http:\\/\\/ryazan.beta.taxistock.ru\\/taxik\\/api\\/doc\\/\",\"city_latitude\":54.610108,\"city_longitude\":39.71308,\"city_spn_latitude\":0.199161,\"city_spn_longitude\":0.360526,\"last_app_android_version\":7045,\"android_driver_apk_link\":\"http:\\/\\/www.taxik.ru\\/a\\/taxik.apk\",\"transfers\":false},{\"city_id\":107,\"city_name\":\"Нахабино (московская область)\",\"parent_city\":1,\"city_api_url\":\"http:\\/\\/beta.taxistock.ru\\/taxik\\/api\\/client\\/\",\"city_domain\":\"beta.taxistock.ru\",\"city_mobile_server\":\"protobuf.taxistock.ru:7777\",\"city_doc_url\":\"http:\\/\\/beta.taxistock.ru\\/taxik\\/api\\/doc\\/\",\"city_latitude\":55.846204,\"city_longitude\":37.168567,\"city_spn_latitude\":0.037595,\"city_spn_longitude\":0.043736,\"last_app_android_version\":7045,\"android_driver_apk_link\":\"http:\\/\\/www.taxik.ru\\/a\\/taxik.apk\"}]}";
    public static String ReadFromfile(String fileName, Context context) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = context.getResources().getAssets()
                    .open(fileName, Context.MODE_WORLD_READABLE);
            isr = new InputStreamReader(fIn,"Cp1251");
            input = new BufferedReader(isr);
            String line = "";
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fIn != null)
                    fIn.close();
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return returnString.toString();
    }
}

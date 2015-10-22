package com.example.damian.myjsonparsing.database;

import com.example.damian.myjsonparsing.model.UserData;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Admin on 21.10.2015.
 */
public class DatabaseGateway {
    public static List<UserData> getAllCities() throws SQLException {
        return HelperFactory.getHelper().getUserDataDAO().getAllCities();
    }
    public static UserData getCity(int id) throws SQLException {
        return HelperFactory.getHelper().getUserDataDAO().getCityById(id);
    }

    public static void insertCity(UserData item) throws SQLException {
        HelperFactory.getHelper().getUserDataDAO().insertCity(item);
    }

    public static void insertCities(Collection<UserData> datas) throws SQLException {
        HelperFactory.getHelper().getUserDataDAO().insertCities(datas);
    }

    public static void deleteCity(UserData item) throws SQLException {
        HelperFactory.getHelper().getUserDataDAO().deleteCity(item);
    }

    public static void deleteCityById(int id) throws SQLException {
        HelperFactory.getHelper().getUserDataDAO().deleteCityById(id);
    }

    public static void deleteCities(Collection<UserData> datas) throws SQLException {
        HelperFactory.getHelper().getUserDataDAO().deleteCities(datas);
    }

    public static void deleteCities() throws SQLException {
        HelperFactory.getHelper().getUserDataDAO().deleteCities();
    }
}

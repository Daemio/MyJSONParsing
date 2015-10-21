package com.example.damian.myjsonparsing.database.dao;

import com.example.damian.myjsonparsing.model.UserData;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 21.10.2015.
 */
public class UserDataDAO extends BaseDaoImpl<UserData,Integer> {
    public UserDataDAO(ConnectionSource connectionSource, Class<UserData> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
    public List<UserData> getAllCities() throws SQLException{
        return this.queryForAll();
    }

    public void insertCity(UserData item) throws SQLException {
        this.createOrUpdate(item);
    }

    public UserData getCityById(int id) throws SQLException {
        return this.queryForId(id);
    }
}

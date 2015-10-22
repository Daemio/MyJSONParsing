package com.example.damian.myjsonparsing.database.dao;

import com.example.damian.myjsonparsing.model.UserData;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.Collection;
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

    public void insertCities(Collection<UserData> datas) throws SQLException {
        for(UserData item : datas){
            this.createOrUpdate(item);
        }
    }

    public UserData getCityById(int id) throws SQLException {
        return this.queryForId(id);
    }

    public void deleteCity(UserData item) throws SQLException {
        this.delete(item);
    }

    public void deleteCityById(int id) throws SQLException {
        this.deleteById(id);
    }

    public void deleteCities(Collection<UserData> datas) throws SQLException {
        this.delete(datas);
    }

    public void deleteCities()  throws SQLException{
        this.deleteBuilder().delete();
    }
}

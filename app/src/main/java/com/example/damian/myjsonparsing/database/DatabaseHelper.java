package com.example.damian.myjsonparsing.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.damian.myjsonparsing.database.dao.UserDataDAO;
import com.example.damian.myjsonparsing.model.UserData;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getSimpleName();

    //database name saved in /data/data/APPNAME/DATABASE_NAME.db
    private static final String DATABASE_NAME ="MyJSONParsing.db";

    //with version increased we will call onUpgrade();
    private static final int DATABASE_VERSION = 1;

    //DAO links for our entities
//    private GoalDAO goalDao = null;
//    private RoleDAO roleDao = null;
    private UserDataDAO userDataDAO;

    //singleton for UserDataDAO
    public UserDataDAO getUserDataDAO() throws SQLException {
        if(userDataDAO == null){
            userDataDAO = new UserDataDAO(getConnectionSource(), UserData.class);
        }
        return userDataDAO;
    }

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Called when no db exists
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource){
        try {
            TableUtils.createTable(connectionSource,UserData.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Called by version increasement
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer,
                          int newVer){
    }
    //called when app is closed
    @Override
    public void close(){
        super.close();
    }
}

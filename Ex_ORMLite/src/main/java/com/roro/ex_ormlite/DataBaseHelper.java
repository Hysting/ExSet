package com.roro.ex_ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by roro on 2015/6/30.
 */
public class DataBaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "my.db";

    private static final int DATABASE_VERSION = 1;
    private Dao<Account, Integer> accoutDao;

    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            Log.i(this.getClass().getName(), "onCreate");
            TableUtils.createTable(connectionSource, Account.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,Account.class,true);
            onCreate(sqLiteDatabase,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static DataBaseHelper mInstance;

    public static synchronized DataBaseHelper getHelper(Context context){
        if (mInstance == null){
            synchronized (DataBaseHelper.class){
                if (mInstance == null){
                    mInstance = new DataBaseHelper(context);
                }
            }
        }
        return mInstance;
    }

    public Dao<Account,Integer> getAccoutDao() throws SQLException {
        if (accoutDao == null){
            accoutDao = getDao(Account.class);
        }
        return accoutDao;
    }

    @Override
    public void close() {
        super.close();
        accoutDao = null;
    }
}

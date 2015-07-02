package com.roro.debugdemo;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNetwork(View view){

    }

    public void onSp(View view){
        SharedPreferences sp = getSharedPreferences("test_sp",MODE_PRIVATE);
        int counter = sp.getInt("counter", 0);
        SharedPreferences.Editor edit = sp.edit();
        int i = counter + 1;
        edit.putInt("counter", i);
        edit.commit();
    }
    public void onSqlite(View view){

    }
}

package com.roro.ex_ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by roro on 2015/6/30.
 */
@DatabaseTable(tableName = "accounts")
public class Account {

    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField
    String name;
    @DatabaseField
    String password;

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Account() {

    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

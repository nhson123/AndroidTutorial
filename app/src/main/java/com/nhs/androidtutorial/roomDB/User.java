package com.nhs.androidtutorial.roomDB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Hoang Son Nguyen nhs@gmx.at on ${DATETIME}.
 */

@Entity(tableName = "user")
public class User {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "user_name")
    private String name;

    @ColumnInfo(name = "user_email")
    private String email;

    //setter and getter

    public void setId(int id) {

        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public String getEmail() {

        return email;
    }
}

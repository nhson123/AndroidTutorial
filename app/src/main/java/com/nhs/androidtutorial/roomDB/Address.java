package com.nhs.androidtutorial.roomDB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Hoang Son Nguyen nhs@gmx.at on 09.06.2018.
 */
@Entity(tableName = "address", foreignKeys =
@ForeignKey(entity = User.class,parentColumns = "id",childColumns = "userID"))
class Addsress {
    @PrimaryKey
    private int id;
    @ColumnInfo(name = "address1")
    private String address1;

    public int getId() {
        return id;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public int getUserID() {
        return userID;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @ColumnInfo(name = "address2")
    private String address2;
    @ColumnInfo(name = "userID")
    private int userID;
}

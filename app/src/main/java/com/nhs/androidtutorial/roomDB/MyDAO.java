package com.nhs.androidtutorial.roomDB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Hoang Son Nguyen nhs@gmx.at on 04.06.2018.
 */

@Dao
public interface MyDAO {
    @Insert
    public void addUser(User user);

    @Query("select * from user")
    public List<User> getUser();

    @Delete
    public void deleteUser(User user);

    @Update
    public void updateUser(User user);
}

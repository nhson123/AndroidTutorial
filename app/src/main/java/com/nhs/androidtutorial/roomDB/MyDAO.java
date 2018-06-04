package com.nhs.androidtutorial.roomDB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

/**
 * Created by Hoang Son Nguyen nhs@gmx.at on 04.06.2018.
 */

@Dao
public interface MyDAO {
    @Insert
    public void addUser(User user);
}

package com.nhs.androidtutorial.roomDB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Hoang Son Nguyen nhs@gmx.at on 04.06.2018.
 */
@Database(entities = {User.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract MyDAO myDao();
}

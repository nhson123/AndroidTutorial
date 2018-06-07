package com.nhs.androidtutorial.roomDB;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nhs.androidtutorial.R;
import com.nhs.androidtutorial.sqlLite.DBHomeFragment;

public class RoomDBActivity extends AppCompatActivity {

    public static android.support.v4.app.FragmentManager fragmentManager;
    //Database declare
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_db);

        fragmentManager = getSupportFragmentManager();
        //RoomDB created
        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"usersDB").allowMainThreadQueries().build();

        if(findViewById(R.id.roomHomeFragment) != null){
            if(savedInstanceState != null){
                return;
            }
        }
        fragmentManager.beginTransaction().add(R.id.roomHomeFragment,new RoomHomeFragment()).commit();
    }
}

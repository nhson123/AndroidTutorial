package com.nhs.androidtutorial.sqlLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Hoang Son Nguyen nhs@gmx.at on ${DATETIME}.
 */
public class ContactDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "create table " + ContactContract.ContactEntry.TABLE_NAME + "(" +
            ContactContract.ContactEntry.CONTRACT_ID + " number, " + ContactContract.ContactEntry.CONTRACT_NAME + " text, " +
            ContactContract.ContactEntry.CONTRACT_EMAIL + " text )";
    public static final String DROP_TABLE = "drop table if exists " + ContactContract.ContactEntry.TABLE_NAME;

    public ContactDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Operations", "Databse created...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("Database Operation", "Databse is created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);

    }

    public void addContact(int id, String name, String email, SQLiteDatabase database){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactEntry.CONTRACT_ID,id);
        contentValues.put(ContactContract.ContactEntry.CONTRACT_NAME,name);
        contentValues.put(ContactContract.ContactEntry.CONTRACT_EMAIL,email);
        //add row if not null
        database.insert(ContactContract.ContactEntry.TABLE_NAME, null, contentValues);
        Log.d("Database Operation", "a row is inserted");
    }
    public Cursor readContacts(SQLiteDatabase database){
        String[]  projections = {ContactContract.ContactEntry.CONTRACT_ID,
        ContactContract.ContactEntry.CONTRACT_NAME, ContactContract.ContactEntry.CONTRACT_EMAIL};

        Cursor cursor = database.query(ContactContract.ContactEntry.TABLE_NAME, projections, null, null, null, null, null);
        return cursor;

    }

    public void updateContact(int id,  String name, String email, SQLiteDatabase database){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactEntry.CONTRACT_NAME, name);
        contentValues.put(ContactContract.ContactEntry.CONTRACT_EMAIL, email);

        String selection = ContactContract.ContactEntry.CONTRACT_ID + " = "+id;
        // check if the id coul found in DB before
        database.update(ContactContract.ContactEntry.TABLE_NAME, contentValues, selection, null);

    }

    public void deleteContact(int id, SQLiteDatabase database){
        String selection = ContactContract.ContactEntry.CONTRACT_ID + " = "+id;
        // check if the id coul found in DB before
        database.delete(ContactContract.ContactEntry.TABLE_NAME,selection,null);
    }
}

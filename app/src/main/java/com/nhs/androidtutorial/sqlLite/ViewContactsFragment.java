package com.nhs.androidtutorial.sqlLite;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nhs.androidtutorial.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewContactsFragment extends Fragment {
    private TextView contactsDisplay;


    public ViewContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_contacts, container, false);
        contactsDisplay = view.findViewById(R.id.contactsView);
        readContracts();
        return view;
    }
    public void readContracts(){
        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();

        Cursor cursor = contactDbHelper.readContacts(database);
        String info = "";
        while (cursor.moveToNext()){
            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTRACT_ID)));
            String name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.CONTRACT_NAME));
            String email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.CONTRACT_EMAIL));
            info = info+"\n" + "id: "+id + "\nname: "+ name + "\nemail: "+email;
        }
        contactsDisplay.setText(info);
        contactDbHelper.close();
    }



}

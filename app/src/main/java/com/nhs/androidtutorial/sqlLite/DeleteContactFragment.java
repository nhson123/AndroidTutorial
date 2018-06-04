package com.nhs.androidtutorial.sqlLite;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nhs.androidtutorial.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteContactFragment extends Fragment {

    TextView contactId;
    Button deleteButton;


    public DeleteContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_contact, container, false);
        contactId = view.findViewById(R.id.deleteIDField);
        deleteButton = view.findViewById(R.id.deleteContactBtn);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int id = Integer.parseInt(contactId.getText().toString());

                    ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
                    SQLiteDatabase database = contactDbHelper.getWritableDatabase();

                    contactDbHelper.deleteContact(id, database);
                    contactDbHelper.close();

                    Toast.makeText(getActivity(), "the Contact is deleted...", Toast.LENGTH_LONG).show();
                    contactId.setText("");
                }catch (Exception e){
                    Toast.makeText(getActivity(), "the entered ID not correct", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }

}

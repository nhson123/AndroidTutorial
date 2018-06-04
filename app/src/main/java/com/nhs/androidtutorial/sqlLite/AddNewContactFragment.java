package com.nhs.androidtutorial.sqlLite;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nhs.androidtutorial.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewContactFragment extends Fragment {

    private Button addButton;
    private EditText contactId, contactName, contactEmail;

    public AddNewContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_new_contact, container, false);

        contactId = view.findViewById(R.id.updateContactIdField);
        contactName = view.findViewById(R.id.updateContacNameField);
        contactEmail = view.findViewById(R.id.updateContactEmailField);
        addButton = view.findViewById(R.id.addNewContactButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = contactId.getText().toString();
                String name = contactName.getText().toString();
                String email = contactEmail.getText().toString();

                ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
                SQLiteDatabase database = contactDbHelper.getWritableDatabase();
                contactDbHelper.addContact(Integer.parseInt(id), name, email, database);
                contactDbHelper.close();
                contactId.setText("");
                contactName.setText("");
                contactEmail.setText("");
                Toast.makeText(getActivity(), "Contact added..", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}

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
public class EditContactFragment extends Fragment {

    private EditText update_id;
    private EditText update_name;
    private EditText update_email;
    private Button updateButton;


    public EditContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_contact, container, false);
        update_id = view.findViewById(R.id.updateContactIdField);
        update_name = view.findViewById(R.id.updateContacNameField);
        update_email = view.findViewById(R.id.updateContactEmailField);
        updateButton = view.findViewById(R.id.updateContactButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                int id = Integer.parseInt(update_id.getText().toString());
                String name = update_name.getText().toString();
                String email = update_email.getText().toString();

                ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
                SQLiteDatabase database = contactDbHelper.getWritableDatabase();
                contactDbHelper.updateContact(id, name, email, database);
                contactDbHelper.close();
                Toast.makeText(getActivity(), "Contact updated..", Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(getActivity(),"id must be correct filled..",Toast.LENGTH_LONG).show();
                }
                update_id.setText("");
                update_name.setText("");
                update_email.setText("");
            }
        });
        return view;
    }

}

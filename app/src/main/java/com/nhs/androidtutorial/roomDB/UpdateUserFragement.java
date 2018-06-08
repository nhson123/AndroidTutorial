package com.nhs.androidtutorial.roomDB;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.nhs.androidtutorial.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserFragement extends Fragment {

    private EditText userId, userName, userEmail;
    private Button updateButton;


    public UpdateUserFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user_fragement, container, false);

        userId = view.findViewById(R.id.updateUserIdField);
        userName = view.findViewById(R.id.updateUserNameField);
        userEmail = view.findViewById(R.id.updateUserEmailField);
        updateButton = view.findViewById(R.id.updateUserBtn);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

}

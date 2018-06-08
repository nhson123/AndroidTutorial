package com.nhs.androidtutorial.roomDB;


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
public class AddUserFragment extends Fragment {

    private EditText userId, userName, userEmail;
    private Button addUserButton;


    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        userId = view.findViewById(R.id.addUserIdField);
        userName = view.findViewById(R.id.addUserNameField);
        userEmail = view.findViewById(R.id.adduserEmailField);
        addUserButton = view.findViewById(R.id.saveUserButton);
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(userId.getText().toString());
                String name = userName.getText().toString();
                String email = userEmail.getText().toString();

                User user = new User();
                user.setEmail(email);
                user.setName(name);
                user.setId(id);

                RoomDBActivity.myAppDatabase.myDao().addUser(user);

                Toast.makeText(getActivity(), "added User, ID: "+user.getId()+", Name: "+user.getName()+", Email "+user.getEmail(),Toast.LENGTH_LONG).show();

                userId.setText("");
                userName.setText("");
                userEmail.setText("");



            }
        });
        return view;
    }

}

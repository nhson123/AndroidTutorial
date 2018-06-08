package com.nhs.androidtutorial.roomDB;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nhs.androidtutorial.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomHomeFragment extends Fragment implements View.OnClickListener {
    private Button addUser, viewUsers, updateUser, deleteUser;

    public RoomHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_room_home, container, false);
        //Add User
        addUser = view.findViewById(R.id.addUserButton);
        addUser.setOnClickListener(this);

        // getUser
        viewUsers = view.findViewById(R.id.viewUserButton);
        viewUsers.setOnClickListener(this);

        updateUser = view.findViewById(R.id.updateUserButton);
        updateUser.setOnClickListener(this);

        deleteUser = view.findViewById(R.id.deleteUserButton);
        deleteUser.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addUserButton:
                RoomDBActivity.fragmentManager.beginTransaction().replace(R.id.roomHomeFragment,new AddUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.viewUserButton:
                RoomDBActivity.fragmentManager.beginTransaction().replace(R.id.roomHomeFragment,new ViewUsersFragment()).addToBackStack(null).commit();
                break;

            case R.id.updateUserButton:
                RoomDBActivity.fragmentManager.beginTransaction().replace(R.id.roomHomeFragment,new UpdateUserFragement()).addToBackStack(null).commit();
                break;

            case R.id.deleteUserButton:
                RoomDBActivity.fragmentManager.beginTransaction().replace(R.id.roomHomeFragment,new DeleteUserFragment()).addToBackStack(null).commit();
                break;
        }
    }
}

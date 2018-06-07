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
    private Button addUser, viewUser, updateUser, deleteUser;

    public RoomHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_room_home, container, false);
        addUser = view.findViewById(R.id.addUserButton);
        addUser.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addUserButton:
                RoomDBActivity.fragmentManager.beginTransaction().replace(R.id.roomHomeFragment,new AddUserFragment()).addToBackStack(null).commit();
        }
    }
}

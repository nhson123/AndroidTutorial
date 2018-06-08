package com.nhs.androidtutorial.roomDB;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nhs.androidtutorial.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewUsersFragment extends Fragment {
    TextView viewUsers;


    public ViewUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_users, container, false);
        viewUsers = view.findViewById(R.id.viewUsers);

        List<User> userList = RoomDBActivity.myAppDatabase.myDao().getUser();
        String result = "";
        for (User user : userList) {
            result = result + "\nUserId: " + user.getId() + "\nName: " + user.getName() + ", Email: " + user.getEmail() + "\n";

        }
        viewUsers.setText(result);
        return view;
    }

}

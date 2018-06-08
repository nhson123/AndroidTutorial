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
public class DeleteUserFragment extends Fragment {

    private EditText userId;
    private Button delUser;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);

        userId = view.findViewById(R.id.delUserIdField);
        delUser = view.findViewById(R.id.delUserButton);
        delUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int id = Integer.parseInt(userId.getText().toString());
                    User user = new User();
                    user.setId(id);
                    RoomDBActivity.myAppDatabase.myDao().deleteUser(user);
                    Toast.makeText(getActivity(), "User deleted...", Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Error: "+e.getMessage().toString(), Toast.LENGTH_LONG).show();

                }

                userId.setText("");
            }
        });
        return view;
    }

}

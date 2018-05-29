package com.nhs.androidtutorial.sqlLite;


import android.app.Activity;
import android.content.Context;
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
public class DBHomeFragment extends Fragment implements View.OnClickListener{

    OnDbOpListener onDbOpListener;

    private Button updateButton, addButton, viewButton, deleteButton;

    public interface OnDbOpListener{
        public void dbOpPerformed(int method);
    }

    public DBHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dbhome, container, false);
        updateButton = view.findViewById(R.id.updateContactButton);
        updateButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.updateContactButton:
                onDbOpListener.dbOpPerformed(0);
                break;
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity)context;
        try {
            onDbOpListener = (OnDbOpListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" muss be implemented with the methodes");
        }
    }

}

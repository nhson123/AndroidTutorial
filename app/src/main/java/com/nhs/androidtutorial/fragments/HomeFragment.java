package com.nhs.androidtutorial.fragments;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nhs.androidtutorial.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment  {


    private Button button;
    private TextView texView;
    EditText editText;
    HomeSecondFragment homeSecondFragment;

    OnMessageReadListener onMessageReadListener;
    OnMessageSendListener onMessageSendListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    public interface OnMessageReadListener{
        public void onMessageRead(String message);
    }

    public interface OnMessageSendListener{
        public Fragment onMessageSend(String message, Fragment fragment);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        button = view.findViewById(R.id.secondHomeFragmentButton);
        texView = view.findViewById(R.id.homeFragmentTextView);
        editText = view.findViewById(R.id.homeFragmentEditText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                homeSecondFragment = new HomeSecondFragment();
                //read and send message to next fragment and Activity
                onMessageSendListener.onMessageSend(message,homeSecondFragment);
                onMessageReadListener.onMessageRead(message);
                FragmentsDynamic.fragmentManager.beginTransaction().replace(R.id.dynFragmentContainer, homeSecondFragment,null).commit();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            onMessageReadListener = (OnMessageReadListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+ " must override onMessageRead....");
        }
        try {
            onMessageSendListener = (OnMessageSendListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+ " must override onMessageSend....");
        }
    }



    @Override
    public void onResume() {
        super.onResume();
        editText.setText("");
    }
}

package com.nhs.androidtutorial.fragments;


import android.app.Activity;
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

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeSecondFragment extends Fragment {

    private Button button;
    HomeFragment.OnMessageReadListener onMessageReadListener;
    EditText editText;
    TextView textView;

    public HomeSecondFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home_second, container, false);
        button = view.findViewById(R.id.thirdFragementButton);
        textView = view.findViewById(R.id.messageReceiverSecond);
        Bundle bundle = getArguments();
        String message = bundle.getString("message");
        textView.setText(message);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = view.findViewById(R.id.homeSecondEditText);
                onMessageReadListener.onMessageRead(editText.getText().toString());
                //FragmentsDynamic.fragementText.setText(this.getClass().getName().toString());
                FragmentsDynamic.fragmentManager.beginTransaction().replace(R.id.dynFragmentContainer, new HomeThirdFragment(),null).addToBackStack(null).commit();


            }
        });
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            onMessageReadListener = (HomeFragment.OnMessageReadListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+ " must override onMessageRead....");
        }
    }
}

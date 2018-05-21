package com.nhs.androidtutorial.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nhs.androidtutorial.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class HomeThirdFragment extends Fragment {

    private Button button;

    public HomeThirdFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_third, container, false);
        button = view.findViewById(R.id.homeFragmentButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentsDynamic.fragementText.setText(this.getClass().getName().toString());
                FragmentsDynamic.fragmentManager.beginTransaction().replace(R.id.dynFragmentContainer, new HomeFragment(),null).addToBackStack(null).commit();
            }
        });
        return view;
    }
}






package com.nhs.androidtutorial.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nhs.androidtutorial.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentsDynamic extends AppCompatActivity implements HomeFragment.OnMessageReadListener, HomeFragment.OnMessageSendListener{


    public static FragmentManager fragmentManager;

    public static TextView fragementText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fragments_dynamic);

        //if the container exists
        if (findViewById(R.id.dynFragmentContainer) != null) {
            //if Bundle allraedy filled
            if(savedInstanceState != null){
                return;
            }
            fragementText = findViewById(R.id.fragmenContainerLabel);
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.add(R.id.dynFragmentContainer, homeFragment, null).addToBackStack(null);
            fragementText.setText(homeFragment.getClass().getName().toString());
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onMessageRead(String message) {
        fragementText = findViewById(R.id.fragmenContainerLabel);
        fragementText.setText(message);

    }

    public Fragment onMessageSend(String message, Fragment fragment) {
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        fragment.setArguments(bundle);
        return fragment;

    }


}

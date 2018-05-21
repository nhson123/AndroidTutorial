package com.nhs.androidtutorial.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhs.androidtutorial.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_article, container, false);
    }

}

package com.nhs.androidtutorial.recyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nhs.androidtutorial.R;

import java.util.Arrays;
import java.util.List;

public class RecyclerViewActivity extends Activity {
    private RecyclerView recyclerView ;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> list;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recyclerViewContainer);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        list = Arrays.asList(getResources().getStringArray(R.array.countries));
        adapter = new RecyclerViewAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }
}

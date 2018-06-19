package com.nhs.androidtutorial.recyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nhs.androidtutorial.R;

public class RecyclerImageViewActivity extends AppCompatActivity {

    private RecyclerView recyclerViewImage;
    private int[] images = {
            R.drawable.hanoi_1,
            R.drawable.hanoi_2,
            R.drawable.hanoi_3,
            R.drawable.hanoi_4,
            R.drawable.hanoi_5,
            R.drawable.hanoi_6,
            R.drawable.hanoi_7,
            R.drawable.hanoi_8

    };

    private RecyclerView.LayoutManager layoutManager;

    private RecyclerImageViewAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_image_view_fragment);
        recyclerViewImage = findViewById(R.id.recyclerImageViewContainer);
        layoutManager = new GridLayoutManager(this,2); //2 column
        recyclerViewImage.setHasFixedSize(true);
        recyclerViewImage.setLayoutManager(layoutManager);
        imageAdapter = new RecyclerImageViewAdapter(images,this);
        recyclerViewImage.setAdapter(imageAdapter);
    }
}

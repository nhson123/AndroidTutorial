package com.nhs.androidtutorial.recyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.nhs.androidtutorial.R;

public class ImageDisplayActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);
        imageView = findViewById(R.id.album_Display);
        imageView.setImageResource(getIntent().getIntExtra("image_id",00));

    }
}

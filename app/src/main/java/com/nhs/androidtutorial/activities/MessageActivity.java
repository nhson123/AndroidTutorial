package com.nhs.androidtutorial.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nhs.androidtutorial.R;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Intent intent = getIntent();
        TextView textView = findViewById(R.id.messageTextView);
        if(!intent.getStringExtra("MESSAGE").toString().equals("")) {
            textView.setText(intent.getStringExtra("MESSAGE"));
        }else{
            textView.setText("no message received");
        }
    }

    public void openFinalActivity(View view) {
        startActivity(new Intent(this, FinalActivity.class));
    }
}

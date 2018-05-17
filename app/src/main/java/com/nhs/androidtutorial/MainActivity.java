package com.nhs.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void messageActivity(View view) {
        EditText editText = findViewById(R.id.mainEditText1);
        Intent intent = new Intent(this, MessageActivity.class);
        intent.putExtra("message",editText.getText().toString());
        startActivity(intent);
    }
}

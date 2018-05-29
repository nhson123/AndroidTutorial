package com.nhs.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.nhs.androidtutorial.activities.MessageActivity;
import com.nhs.androidtutorial.fragments.Fragments;
import com.nhs.androidtutorial.fragments.FragmentsDynamic;
import com.nhs.androidtutorial.preferencesAPI.PreferenceAPI;
import com.nhs.androidtutorial.sqlLite.SqlLiteActivity;

/**
 * Tutorial location https://www.youtube.com/playlist?list=PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void messageActivity(View view) {
        EditText editText = findViewById(R.id.mainEditText1);
        Intent intent = new Intent(this, MessageActivity.class);
        intent.putExtra("MESSAGE",editText.getText().toString());
        startActivity(intent);
    }

    public void openFragments(View view) {
        Intent intent = new Intent(this, Fragments.class);
        startActivity(intent);
    }

    public void openDynFragment(View view) {
        Intent intent = new Intent(this, FragmentsDynamic.class);
        startActivity(intent);
    }

    public void preverenceAPI(View view) {
        Intent intent = new Intent(this, PreferenceAPI.class);
        startActivity(intent);
}

    public void openSQLLite(View view) {
        Intent intent = new Intent(this, SqlLiteActivity.class);
        startActivity(intent);
    }
}

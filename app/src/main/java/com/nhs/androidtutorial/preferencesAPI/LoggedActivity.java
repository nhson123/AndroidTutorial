package com.nhs.androidtutorial.preferencesAPI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nhs.androidtutorial.R;

public class LoggedActivity extends Activity {

    private PreferenceConfig preferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
        preferenceConfig = new PreferenceConfig(getApplicationContext());
    }

    public void userLogout(View view){
        preferenceConfig.writeLoginStatus(false);
        startActivity(new Intent(this, PreferenceAPI.class));
        finish();

    }
}

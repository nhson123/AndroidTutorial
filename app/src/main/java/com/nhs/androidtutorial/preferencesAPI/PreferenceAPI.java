package com.nhs.androidtutorial.preferencesAPI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nhs.androidtutorial.R;

public class PreferenceAPI extends AppCompatActivity {
    private PreferenceConfig preferenceConfig;
    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_api);
        preferenceConfig = new PreferenceConfig(getApplicationContext());

        username = findViewById(R.id.loginUsername);
        password = findViewById(R.id.loginPwd);

        //check if already logged
        if(preferenceConfig.readLoginStatus()){
            startActivity(new Intent(this, LoggedActivity.class));
            finish();
        }
    }

    public void userLogin(View view){
        String userName = username.getText().toString();
        String passWord = password.getText().toString();

        if(userName.equals(getResources().getString(R.string.user_name))&&
        passWord.equals(getResources().getString(R.string.user_pwd))){
            startActivity(new Intent(this, LoggedActivity.class));
            preferenceConfig.writeLoginStatus(true);
            finish();
        }else{
            Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
        }

    }
}

package com.nhs.androidtutorial.preferencesAPI;

import android.content.Context;
import android.content.SharedPreferences;

import com.nhs.androidtutorial.R;

/**
 * Created by Hoang Son Nguyen nhs@gmx.at on ${DATETIME}.
 */
public class PreferenceConfig {
    private SharedPreferences sharedPreferences;
    private Context context;

    public PreferenceConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preference), Context.MODE_PRIVATE);

    }

    public void writeLoginStatus(boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preference), status);
        editor.commit();
    }

    public boolean readLoginStatus() {
        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preference), false);
        return status;
    }
}

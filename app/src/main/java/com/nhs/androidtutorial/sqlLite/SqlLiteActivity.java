package com.nhs.androidtutorial.sqlLite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nhs.androidtutorial.R;

public class SqlLiteActivity extends AppCompatActivity implements DBHomeFragment.OnDbOpListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_lite);

        if (findViewById(R.id.dbHomeFragment) != null) {
            if (savedInstanceState != null) {
                return;
            }
            DBHomeFragment dbHomeFragment = new DBHomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.dbHomeFragment, dbHomeFragment).commit();
        }
    }

    @Override
    public void dbOpPerformed(int method) {
        switch (method) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.dbHomeFragment, new EditContactFragment()).addToBackStack(null).commit();
        }

    }
}

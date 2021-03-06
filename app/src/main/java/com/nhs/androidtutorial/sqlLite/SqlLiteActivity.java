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

    //Replace the Fragments in SQLiteHome
    @Override
    public void dbOpPerformed(int method) {
        switch (method) {
            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.dbHomeFragment, new DeleteContactFragment()).addToBackStack(null).commit();
                break;

            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.dbHomeFragment, new EditContactFragment()).addToBackStack(null).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.dbHomeFragment, new ViewContactsFragment()).addToBackStack(null).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.dbHomeFragment, new AddNewContactFragment()).addToBackStack(null).commit();
                break;
        }

    }
}

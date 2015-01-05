package vipul.com.sharedpreference;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class WelcomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();

        String username = bundle.getString("username");
        String password = bundle.getString("password");

        new AlertDialog.Builder(this).
                setTitle("Welcome").
                setMessage(username+" "+password).
                setPositiveButton("Thanks",null).
                show();

    }
}

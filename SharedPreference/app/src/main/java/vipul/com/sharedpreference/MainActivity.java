package vipul.com.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity
  implements View.OnClickListener{

    private Button btnSubmit;
    private EditText txtUsername,txtPassword;
    private CheckBox chkSave;
    private String username,password;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = password = null;

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        txtUsername = (EditText)findViewById(R.id.txtUsername);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        chkSave = (CheckBox)findViewById(R.id.chkSave);

        btnSubmit.setOnClickListener(this);

        preferences = getSharedPreferences
                ("store", Context.MODE_PRIVATE);

        checkSavedCredentials();
    }

    private void checkSavedCredentials()
    {
        if(preferences.contains("username")
                && preferences.contains("password"))
        {
            username = preferences.getString("username","");
            password = preferences.getString("password","");
            switchActivity();
        }
    }

    @Override
    public void onClick(View v) {

        username = txtUsername.getText()
                .toString();
        password = txtPassword.getText()
                .toString();

        if(chkSave.isChecked()) {
            preferences.edit().
                    putString("username",username).
                    commit();
            preferences.edit().
                    putString("password",password).
                    commit();
        }

        switchActivity();
    }

    private void switchActivity()
    {
        Intent intent = new Intent(MainActivity.this,
                WelcomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("username",username);
        bundle.putString("password",password);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}

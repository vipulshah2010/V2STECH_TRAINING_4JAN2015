package vipul.com.loginapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity
  implements View.OnClickListener{

    private Button btnLogin , btnReset;
    private EditText txtUsername,txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnReset = (Button)findViewById(R.id.btnReset);

        btnLogin.setOnClickListener(this);
        btnReset.setOnClickListener(this);

        txtUsername = (EditText)findViewById(R.id.txtUsername);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnLogin:
                String username = txtUsername.getText().
                        toString();
                String password = txtPassword.getText().
                        toString();

                if(TextUtils.isEmpty(username) ||
                        TextUtils.isEmpty(password))
                {
                    Toast.makeText(this,"Error!",
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(username.equals("Vipul") &&
                            password.equals("Shah"))
                    {
                        Toast.makeText(this,"Success!",
                                Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(this,"Failure!",
                                Toast.LENGTH_LONG).show();
                    }
                }


                break;
            case R.id.btnReset:
                txtUsername.setText("");
                txtPassword.setText("");
                txtUsername.requestFocus();
                break;
        }
    }
}

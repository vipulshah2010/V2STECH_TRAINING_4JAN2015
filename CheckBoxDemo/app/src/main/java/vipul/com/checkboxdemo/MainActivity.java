package vipul.com.checkboxdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox chkCricket,chkHockey,chkFootball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkCricket = (CheckBox)findViewById(R.id.chkCricket);
        chkFootball = (CheckBox)findViewById(R.id.chkFootball);
        chkHockey = (CheckBox)findViewById(R.id.chkHockey);

        chkCricket.setOnCheckedChangeListener(this);
        chkFootball.setOnCheckedChangeListener(this);
        chkHockey.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String message = "";

        switch (buttonView.getId())
        {
            case R.id.chkCricket:
                message = "Cricket is";
                break;
            case R.id.chkFootball:
                message = "Football is";
                break;
            case R.id.chkHockey:
                message = "Hockey is";
                break;
        }

        if(isChecked)
        {
            message += " Checked";
        }
        else {
            message += " Unchecked";
        }

        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}

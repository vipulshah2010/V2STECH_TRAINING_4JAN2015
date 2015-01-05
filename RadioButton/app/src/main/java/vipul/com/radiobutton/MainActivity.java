package vipul.com.radiobutton;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genderGroup = (RadioGroup)findViewById(R.id.genderGroup);
        genderGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId)
        {
            case R.id.rdMale:
                Toast.makeText(this,"Male Checked!",Toast.LENGTH_LONG).show();
                break;
            case R.id.rdFemale:
                Toast.makeText(this,"Female Checked!",Toast.LENGTH_LONG).show();
                break;
        }
    }
}

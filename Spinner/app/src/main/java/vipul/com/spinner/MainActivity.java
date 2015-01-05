package vipul.com.spinner;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    private Spinner countrySpinner;
    private String[] countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countrySpinner = (Spinner) findViewById(R.id.countrySpinner);
        countrySpinner.setOnItemSelectedListener(this);

        countries = getResources().getStringArray(R.array.countries);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Selected " + countries[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

package vipul.com.autocompletetextview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private AutoCompleteTextView namesTextView;
    private ArrayAdapter<String> namesAdapter;
    private ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namesTextView = (AutoCompleteTextView)findViewById(R.id.namesTextView);

        names = new ArrayList<>();

        names.add("Vipul");
        names.add("Vinay");
        names.add("Abhinav");
        names.add("Abhishek");

        namesAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_dropdown_item_1line,names);

        namesTextView.setAdapter(namesAdapter);
    }
}

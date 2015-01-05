package vipul.com.countryfetch;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity
        implements View.OnClickListener,AdapterView.OnItemClickListener {
    private Button btnFetchData;
    private ListView listCountries;
    private ProgressBar progress;
    private ArrayAdapter<String> countryAdapter;
    private ArrayList<Country> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries = new ArrayList<>();

        btnFetchData = (Button)
                findViewById(R.id.btnFetchCountry);
        listCountries = (ListView)
                findViewById(R.id.listCountries);
        progress = (ProgressBar)
                findViewById(R.id.progress);

        btnFetchData.setOnClickListener(this);

        countryAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1);

        listCountries.setAdapter(countryAdapter);
        listCountries.setOnItemClickListener(this);

        ConnectivityManager manager;

    }

    @Override
    public void onClick(View v) {
        fetchNetworkData();
    }

    private void fetchNetworkData() {
        progress.setVisibility(View.VISIBLE);

        new Thread() {
            @Override
            public void run() {
                try {
                    URL url =
                            new URL("http://www.json-generator.com/api/json/get/bSxuGSPoRK?indent=2");

                    HttpURLConnection connection = (HttpURLConnection) url.
                            openConnection();

                    connection.connect();

                    Log.i("vipul", "Code =>" + connection.getResponseCode());

                    InputStream inputStream =
                            connection.getInputStream();

                    InputStreamReader reader = new
                            InputStreamReader(inputStream);

                    BufferedReader bufferedReader =
                            new BufferedReader(reader);

                    StringBuilder builder = new StringBuilder();
                    String tempString = "";

                    while ((tempString = bufferedReader.readLine()) != null) {
                        builder.append(tempString);
                        builder.append(System.getProperty("line.separator"));
                    }

                    final String response = builder.toString();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (TextUtils.isEmpty(response)) {
                                Toast.makeText(MainActivity.this,
                                        "Error!!!", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(MainActivity.this,
                                        response, Toast.LENGTH_LONG).show();
                                try {
                                    parseResponse(response);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });

                } catch (Exception e) {

                }
            }
        }.start();

    }

    private void parseResponse(String response) throws
            JSONException {
        progress.setVisibility(View.GONE);
        listCountries.setVisibility(View.VISIBLE);

        JSONArray jsonArray = new JSONArray(response);

        for(int i=0 ;i<jsonArray.length();i++)
        {
            JSONObject countryObject =
                    jsonArray.getJSONObject(i);

            String name = countryObject.getString("name");
            String currency = countryObject.getString("currency");

            countries.add(new Country(name,currency));

            countryAdapter.add(name);

        }

        countryAdapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Country country = countries.get(position);

        Toast.makeText(MainActivity.this,
                country.currency, Toast.LENGTH_LONG).show();
    }
}

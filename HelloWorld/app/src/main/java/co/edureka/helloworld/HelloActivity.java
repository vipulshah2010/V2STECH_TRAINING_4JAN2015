package co.edureka.helloworld;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;


public class HelloActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("edureka","onCreate Called");
        setContentView(R.layout.activity_hello);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("edureka","onStart Called");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("edureka","onResume Called");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("edureka","onPause Called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("edureka","onStop Called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("edureka","onDestroy Called");

    }
}

package vipul.com.fruitslist;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ListView mFruitsList;
    private ArrayList<Fruit> fruits;
    private FruitAdapter fruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFruitsList = (ListView)
                findViewById(R.id.fruitsList);

        fruits = new ArrayList<>();

        fruits.add(new Fruit("Mango",
                Color.YELLOW,"120 INR"));
        fruits.add(new Fruit("Grapes",
                Color.GREEN,"30 INR"));
        fruits.add(new Fruit("Blueberry",
                Color.BLUE,"90 INR"));
        fruits.add(new Fruit("Blackberry",
                Color.BLACK,"800 INR"));

        fruitAdapter = new FruitAdapter
                (this,fruits);

        mFruitsList.setAdapter(fruitAdapter);

    }
}

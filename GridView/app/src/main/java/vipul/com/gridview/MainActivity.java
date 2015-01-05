package vipul.com.gridview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private GridView gridView;
    private ArrayList<Integer> images;
    private FlowersAdapter flowersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.gridView);

        images = new ArrayList<>();
        images.add(R.drawable.p1);
        images.add(R.drawable.p2);
        images.add(R.drawable.p3);
        images.add(R.drawable.p4);
        images.add(R.drawable.p5);
        images.add(R.drawable.p6);
        images.add(R.drawable.p7);
        images.add(R.drawable.p8);
        images.add(R.drawable.p9);
        images.add(R.drawable.p10);
        images.add(R.drawable.p11);
        images.add(R.drawable.p12);

        flowersAdapter = new FlowersAdapter
                (this,images);
        gridView.setAdapter(flowersAdapter);
    }
}

package vipul.com.fruitslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vipulshah on 12/28/14.
 */
public class
        FruitAdapter extends BaseAdapter {

    private MainActivity mainActivity;
    private ArrayList<Fruit> fruits;

    public FruitAdapter(MainActivity mainActivity,
                        ArrayList<Fruit> fruits) {
        this.mainActivity = mainActivity;
        this.fruits = fruits;
    }

    @Override
    public int getCount() {
        return fruits.size();
    }

    @Override
    public Object getItem(int position) {
        return fruits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View fruit_row =
                LayoutInflater.from(mainActivity).
                        inflate
                                (R.layout.fruit_row,parent,false);

        TextView fruit_name = (TextView)fruit_row.findViewById(R.id.fruitName);
        View fruit_color =(View) fruit_row.findViewById(R.id.fruitColor);
        TextView fruit_price = (TextView)fruit_row.findViewById(R.id.fruitPrice);

        Fruit fruit = fruits.get(position);

        fruit_name.setText(fruit.fruitName);
        fruit_color.setBackgroundColor(fruit.fruitColor);
        fruit_price.setText(fruit.fruitPrice);

        return fruit_row;
    }
}

package vipul.com.gridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by vipulshah on 12/28/14.
 */
public class FlowersAdapter extends BaseAdapter {

    private MainActivity mainActivity;
    private ArrayList<Integer> images;

    public FlowersAdapter
            (MainActivity mainActivity,
             ArrayList<Integer> images) {
        this.mainActivity = mainActivity;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView
            (int position, View convertView,
             ViewGroup parent) {

        View grid_row = LayoutInflater.
                from(mainActivity).
                inflate(R.layout.grid_row, parent, false);

        ImageView imageView = (ImageView)grid_row.
                findViewById(R.id.imageView);
        imageView.setImageResource(images.get(position));

        return grid_row;
    }
}

package vipul.com.frameanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);

        AnimationDrawable drawable = (AnimationDrawable) imageView.getDrawable();
        drawable.start();

    }
}

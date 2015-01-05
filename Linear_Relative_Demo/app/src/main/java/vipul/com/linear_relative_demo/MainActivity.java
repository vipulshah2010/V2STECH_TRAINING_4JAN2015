package vipul.com.linear_relative_demo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity
  implements View.OnClickListener{

    private Button button1,button2,button3,
            button4,button5,button6,button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);

        button1.setOnClickListener(MainActivity.this);
        button2.setOnClickListener(MainActivity.this);
        button3.setOnClickListener(MainActivity.this);
        button4.setOnClickListener(MainActivity.this);
        button5.setOnClickListener(MainActivity.this);
        button6.setOnClickListener(MainActivity.this);
        button7.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        String message = "";
        switch (v.getId())
        {
            case R.id.button1:
                message = "Button1 Clicked";
                break;
            case R.id.button2:
                message = "Button2 Clicked";
                break;
            case R.id.button3:
                message = "Button3 Clicked";
                break;
            case R.id.button4:
                message = "Button4 Clicked";
                break;
            case R.id.button5:
                message = "Button5 Clicked";
                break;
            case R.id.button6:
                message = "Button6 Clicked";
                break;
            case R.id.button7:
                message = "Button7 Clicked";
                break;
        }

        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();;

    }
}

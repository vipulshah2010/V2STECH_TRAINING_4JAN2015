package vipul.com.dialogdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity
implements View.OnClickListener,
        DialogInterface.OnClickListener {

    private Button btnShowInfoDialog,btnShowListDialog;
    private String[] countries = {
            "India","USA","London","IRAQ"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowInfoDialog = (Button)findViewById
                (R.id.btnShowInfoDialog);
        btnShowListDialog = (Button)findViewById
                (R.id.btnShowListDialog);

        btnShowInfoDialog.setOnClickListener(this);
        btnShowListDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnShowInfoDialog:
                showInfoDialog();
                break;
            case R.id.btnShowListDialog:
                showListDialog();
                break;
        }
    }

    private void showInfoDialog()
    {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("Please Confirm");
        builder.setMessage("Sure?");
        builder.setPositiveButton("Yes",this);
        builder.setNegativeButton("No", this);
        builder.show();
    }

    private void showListDialog()
    {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("Please Select Country");
        builder.setItems(countries,
                new DialogInterface.OnClickListener()
            {
            @Override
            public void onClick(DialogInterface
                                        dialog,
                                int which) {
                Toast.makeText(MainActivity.this,
                        "Selected "+
                        countries[which],
                        Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        switch (which)
        {
            case AlertDialog.BUTTON_POSITIVE:
                Toast.makeText(this,"Yes Clicked",
                        Toast.LENGTH_LONG).show();
                break;
            case AlertDialog.BUTTON_NEGATIVE:
                Toast.makeText(this,"No Clicked",
                        Toast.LENGTH_LONG).show();
                break;
        }

    }
}

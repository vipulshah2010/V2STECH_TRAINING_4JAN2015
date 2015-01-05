package vipul.com.datetimepickerdialogs;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity
        implements View.OnClickListener {

    private Button btnShowDatePickerDialog, btnShowTimePickerDialog;
    private Calendar calendar;

    private int date, month, year;
    private int hours, minutes;

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDatePickerDialog = (Button) findViewById(R.id.btnSelectDate);
        btnShowTimePickerDialog = (Button) findViewById(R.id.btnSelectTime);

        btnShowDatePickerDialog.setOnClickListener(this);
        btnShowTimePickerDialog.setOnClickListener(this);

        calendar = Calendar.getInstance();

    }

    private void getCurrentDate() {
        date = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
    }

    private void getCurrentTime() {
        hours = calendar.get(Calendar.HOUR);
        minutes = calendar.get(Calendar.MINUTE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSelectDate:
                showDatePickerDialog();
                break;
            case R.id.btnSelectTime:
                showTimePickerDialog();
                break;
        }
    }

    private void showDatePickerDialog() {
        getCurrentDate();

        datePickerDialog = new DatePickerDialog
                (this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        btnShowDatePickerDialog.
                                setText
                                        (dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                },year,month,date);
        datePickerDialog.show();

    }

    private void showTimePickerDialog() {
        getCurrentTime();

        timePickerDialog = new TimePickerDialog
                (this,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        btnShowTimePickerDialog.setText(hourOfDay+":"+minute);
                    }
                },hours,minutes,true);
        timePickerDialog.show();
    }

}

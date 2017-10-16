package com.project.my.thanh.nhat.pham.dang.timedatepickerdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox24hour, checkBoxMode;
    TimePicker timePicker;
    TextView textViewTime;
    EditText edtInputTime, edtInputDate ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initCreate();
        initEvent();
        initUpdate();
    }

    private void initUpdate() {

    }

    private void initEvent() {
        //change time in time picker
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minutes) {

                if (timePicker.is24HourView()) {
                    textViewTime.setText("TIME: "+ hour + " : " + minutes);
                } else {
                    textViewTime.setText("TIME: "+ hour + " : " + minutes);
                }

            }
        });

        checkBox24hour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox24hour.isChecked()) {
                    timePicker.setIs24HourView(true);
                } else {
                    timePicker.setIs24HourView(false);
                }
            }
        });

        edtInputTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int hourNow = calendar.get(Calendar.HOUR_OF_DAY);
                int minuteNow = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog;
                timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                                edtInputTime.setText(hour + " : " + minute);
                            }
                        }, hourNow, minuteNow, true);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();

            }
        });

        edtInputDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(calendar.MONTH);
                int day = calendar.get(calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this , new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        edtInputDate.setText(day + "|" + month + "|" +year);
                    }
                },year, month, day);
                datePickerDialog.setTitle("date change");
                datePickerDialog.show();
            }
        });
    }

    private void initCreate() {
        checkBox24hour = (CheckBox) findViewById(R.id.checkbox24hour);
        checkBoxMode = (CheckBox) findViewById(R.id.checkboxMode);
        timePicker = (TimePicker) findViewById(R.id.TimePicker);
        textViewTime = (TextView) findViewById(R.id.TextView_Time);
        edtInputTime = (EditText) findViewById(R.id.EditTextInputTime);
        edtInputDate = (EditText) findViewById(R.id.EditTextInputDate);

    }

}

package com.example.haldir.rtdatepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private NumberPicker dayPicker;
    private NumberPicker monthPicker;
    private NumberPicker yearPicker;

    private TextView dayView;
    private TextView monthView;
    private TextView yearView;
    private TextView dateView;

    private Button setButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dayPicker = (NumberPicker) findViewById(R.id.dayPicker);
        monthPicker = (NumberPicker) findViewById(R.id.monthPicker);
        yearPicker = (NumberPicker) findViewById(R.id.yearPicker);
        dayView = (TextView) findViewById(R.id.dayView);
        monthView = (TextView) findViewById(R.id.monthView);
        yearView = (TextView) findViewById(R.id.yearView);
        dateView = (TextView) findViewById(R.id.dateView);
        setButton = (Button) findViewById(R.id.setButton);

        dayPicker.setMinValue(1);
        dayPicker.setMaxValue(31);

        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(12);

        yearPicker.setMinValue(1900);
        yearPicker.setMaxValue(2017);

        dayPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                dayView.setText(String.valueOf(dayPicker.getValue()));
            }
        });
        monthPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                monthView.setText(String.valueOf(monthPicker.getValue()));
            }
        });
        yearPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                yearView.setText(String.valueOf(yearPicker.getValue()));
            }
        });
    }

    public void onClick(View view){
    dateView.setText(String.valueOf(dayPicker.getValue()) + " - " + String.valueOf(monthPicker.getValue()) + " - " + String.valueOf(yearPicker.getValue()));


    }
}

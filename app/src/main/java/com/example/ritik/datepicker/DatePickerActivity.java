package com.example.ritik.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import java.util.Calendar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class DatePickerActivity extends AppCompatActivity {

    private TextView pDisplayDate;
    private Button pPickDate;
    private int pDay;
    private int pMonth;
    private int pYear;
    static final int DATE_DIALOG_ID = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        pDisplayDate = (TextView) findViewById(R.id.date);
        pPickDate = (Button) findViewById(R.id.pick_date);

        final Calendar cal = Calendar.getInstance();
        pDay = cal.get(Calendar.DAY_OF_MONTH);
        pMonth = cal.get(Calendar.MONTH);
        pYear = cal.get(Calendar.YEAR);

        updateDisplay();
    }

    public void updateDisplay()
    {
        pDisplayDate.setText(new StringBuilder()
                .append(pDay).append('/')
                .append(pMonth+1).append('/')
                .append(pYear).append(' '));
    }

    public void pickDate(View view)
    {
        showDialog(DATE_DIALOG_ID);
    }

    private DatePickerDialog.OnDateSetListener pDateSetListener = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            pYear = year;
            pMonth = month;
            pDay = day;

            updateDisplay();
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id)
        {
            case DATE_DIALOG_ID:
            {
                return new DatePickerDialog(this ,pDateSetListener ,pYear ,pMonth ,pDay);
            }
        }
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_date_picker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

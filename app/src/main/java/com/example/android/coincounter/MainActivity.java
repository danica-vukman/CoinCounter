package com.example.android.coincounter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    public static final String PREFS_NAME = "MyPrefsFile";

    int fiveLpCount;
    int tenLpCount;
    int twentyLpCount;
    int fiveKnCount;
    int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 1);
        fiveLpCount = settings.getInt("fiveLpCount", 0);
        tenLpCount = settings.getInt("tenLpCount", 0);
        twentyLpCount = settings.getInt("twentyLpCount", 0);
        fiveKnCount = settings.getInt("fiveKnCount", 0);
        sum = settings.getInt("sum", 0);

        displaySum(sum);
        display10LpCount(tenLpCount);
        display5LpCount(fiveLpCount);
    display20LpCount(twentyLpCount);
        display5KnCount(fiveKnCount);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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



    public void display5LpCount(int input) {
        TextView fiveLpCountTextView = (TextView) findViewById(R.id.five_lp_count);
        fiveLpCountTextView.setText("" + input);
    }

    public void add5Lp(View view) {
        fiveLpCount = fiveLpCount + 1;
        display5LpCount(fiveLpCount);
        calculateSum();
        displaySum(sum);
    }

    public void remove5Lp(View view) {

        if (fiveKnCount > 0) {
        fiveLpCount = fiveLpCount - 1;
        display5LpCount(fiveLpCount);
        calculateSum();
        displaySum(sum);}
    }
    public void add5LpTime5(View view) {
        fiveLpCount = fiveLpCount + 5;
        display5LpCount(fiveLpCount);
        calculateSum();
        displaySum(sum);
    }

    public void display10LpCount(int input) {
        TextView tenLpCountTextView = (TextView) findViewById(R.id.ten_lp_count);
        tenLpCountTextView.setText("" + input);
    }

    public void add10Lp(View view) {
        tenLpCount = tenLpCount + 1;
        display10LpCount(tenLpCount);
        calculateSum();
        displaySum(sum);
    }

    public void remove10Lp(View view) {

        if (tenLpCount > 0) {
        tenLpCount = tenLpCount - 1;
        display10LpCount(tenLpCount);
        calculateSum();
        displaySum(sum);}
    }
    public void add10LpTime5(View view) {
        tenLpCount = tenLpCount + 5;
        display10LpCount(tenLpCount);
        calculateSum();
        displaySum(sum);
    }

    public void display20LpCount(int input) {
        TextView twentyLpCountTextView = (TextView) findViewById(R.id.twenty_lp_count);
        twentyLpCountTextView.setText("" + input);
    }

    public void add20Lp(View view) {
        twentyLpCount = twentyLpCount + 1;
        display20LpCount(twentyLpCount);
        calculateSum();
        displaySum(sum);
    }

    public void remove20Lp(View view) {

        if(twentyLpCount >0) {
        twentyLpCount = twentyLpCount - 1;
        display20LpCount(twentyLpCount);
        calculateSum();
        displaySum(sum);}
    }
    public void add20LpTime5(View view) {
        twentyLpCount = twentyLpCount + 5;
        display20LpCount(twentyLpCount);
        calculateSum();
        displaySum(sum);
    }

    public void display5KnCount(int input) {
        TextView fiveKnCountTextView = (TextView) findViewById(R.id.five_kn_count);
        fiveKnCountTextView.setText("" + input);
    }

    public void add5Kn(View view) {
        fiveKnCount = fiveKnCount + 1;
        display5KnCount(fiveKnCount);
        calculateSum();
        displaySum(sum);
    }

    public void remove5Kn(View view) {

        if(fiveKnCount > 0) {
        fiveKnCount = fiveKnCount - 1;
        display5KnCount(fiveKnCount);
        calculateSum();
        displaySum(sum);}
    }
    public void add5KnTime5(View view) {
        fiveKnCount = fiveKnCount + 5;
        display5KnCount(fiveKnCount);
        calculateSum();
        displaySum(sum);
    }

    public void resetCounts() {
        fiveKnCount = 0;
        tenLpCount = 0;
        twentyLpCount = 0;
        fiveLpCount = 0;
        sum = 0;
        display5KnCount(fiveKnCount);
        display20LpCount(twentyLpCount);
        display10LpCount(tenLpCount);
        display5LpCount(fiveLpCount);
        displaySum(sum);

    }
    public void onButtonPressed(View view) {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to reset the counter?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        resetCounts();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
    public int calculateSum() {
   sum = fiveKnCount + fiveLpCount + twentyLpCount + tenLpCount;
   return sum;}

     public void displaySum(int number) {
         TextView sumTextView = (TextView) findViewById(R.id.sumCount);
         sumTextView.setText("" + number);
     }

    protected void onStop(){
        super.onStop();
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 1);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("fiveLpCount", fiveLpCount);
        editor.putInt("tenLpCount", tenLpCount);
        editor.putInt("twentyLpCount", twentyLpCount);
        editor.putInt("fiveKnCount", fiveKnCount);
        editor.putInt("sum", sum);

        editor.commit();

    }

}
package com.example.android.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.graphics.Color.rgb;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {


        /**Getting data from Views**/
        EditText typeViewq1 = (EditText) findViewById(R.id.question1);
        String question1 = typeViewq1.getText().toString().trim();


        CheckBox checkBox1q2 = (CheckBox) findViewById(R.id.checkbox1_q2);
        boolean hasCheckbox1q2 = checkBox1q2.isChecked();

        CheckBox checkBox2q2 = (CheckBox) findViewById(R.id.checkbox2_q2);
        boolean hasCheckbox2q2 = checkBox2q2.isChecked();

        CheckBox checkBox3q2 = (CheckBox) findViewById(R.id.checkbox3_q2);
        boolean hasCheckbox3q2 = checkBox3q2.isChecked();

        CheckBox checkBox4q2 = (CheckBox) findViewById(R.id.checkbox4_q2);
        boolean hasCheckbox4q2 = checkBox4q2.isChecked();


        RadioButton radioq3yes = (RadioButton) findViewById(R.id.radio_q3_yes);
        boolean checkedq3yes = radioq3yes.isChecked();

        RadioButton radioq3no = (RadioButton) findViewById(R.id.radio_q3_no);
        boolean checkedq3no = radioq3no.isChecked();


        RadioButton radioq4yes = (RadioButton) findViewById(R.id.radio_q4_yes);
        boolean checkedq4yes = radioq4yes.isChecked();

        RadioButton radioq4no = (RadioButton) findViewById(R.id.radio_q4_no);
        boolean checkedq4no = radioq4no.isChecked();


        CheckBox checkBox1q5 = (CheckBox) findViewById(R.id.checkbox1_q5);
        boolean hasCheckbox1q5 = checkBox1q5.isChecked();

        CheckBox checkBox2q5 = (CheckBox) findViewById(R.id.checkbox2_q5);
        boolean hasCheckbox2q5 = checkBox2q5.isChecked();

        CheckBox checkBox3q5 = (CheckBox) findViewById(R.id.checkbox3_q5);
        boolean hasCheckbox3q5 = checkBox3q5.isChecked();


        RadioButton radioq6yes = (RadioButton) findViewById(R.id.radio_q6_yes);
        boolean checkedq6yes = radioq6yes.isChecked();

        RadioButton radioq6no = (RadioButton) findViewById(R.id.radio_q6_no);
        boolean checkedq6no = radioq6no.isChecked();


        CheckBox checkBox1q7 = (CheckBox) findViewById(R.id.checkbox1_q7);
        boolean hasCheckbox1q7 = checkBox1q7.isChecked();

        CheckBox checkBox2q7 = (CheckBox) findViewById(R.id.checkbox2_q7);
        boolean hasCheckbox2q7 = checkBox2q7.isChecked();

        CheckBox checkBox3q7 = (CheckBox) findViewById(R.id.checkbox3_q7);
        boolean hasCheckbox3q7 = checkBox3q7.isChecked();

        /** Wrong answers **/
        if(hasCheckbox1q2){
            checkBox1q2.setTextColor(rgb(255,0,0));
        }

        if(hasCheckbox2q2){
            checkBox2q2.setTextColor(rgb(255,0,0));
        }

        if (checkedq3no) {
            radioq3no.setTextColor(rgb(255,0,0));
        }

        if (checkedq4no) {
            radioq4no.setTextColor(rgb(255,0,0));
        }

        if(hasCheckbox1q5){
            checkBox1q5.setTextColor(rgb(255,0,0));
        }

        if(hasCheckbox3q5){
            checkBox3q5.setTextColor(rgb(255,0,0));
        }

        if (checkedq6no) {
            radioq6no.setTextColor(rgb(255,0,0));
        }

        if(hasCheckbox2q7){
            checkBox2q7.setTextColor(rgb(255,0,0));
        }
        if(hasCheckbox3q7){
            checkBox3q7.setTextColor(rgb(255,0,0));
        }

        /** Counting correct answers **/
        int total = 0;
        String correctq1_eng = "salmon",
                correctq1_pol_ver1 = "losos",
                correctq1_pol_ver2 = "łosoś";

        if (question1.equalsIgnoreCase(correctq1_eng) || question1.equalsIgnoreCase(correctq1_pol_ver1) || question1.equalsIgnoreCase(correctq1_pol_ver2)) {
            total += 1;
            typeViewq1.setTextColor(rgb(61,158,20));
        }else{
            typeViewq1.setTextColor(rgb(255,0,0));
        }

        if (hasCheckbox3q2) {
            total += 1;
            checkBox3q2.setTextColor(rgb(61,158,20));
        }

        if (hasCheckbox4q2) {
            total += 1;
            checkBox4q2.setTextColor(rgb(61,158,20));
        }

        if (checkedq3yes) {
            total += 1;
            radioq3yes.setTextColor(rgb(61,158,20));
        }

        if (checkedq4yes) {
            total += 1;
            radioq4yes.setTextColor(rgb(61,158,20));
        }

        if (hasCheckbox2q5) {
            total += 1;
            checkBox2q5.setTextColor(rgb(61,158,20));
        }

        if (checkedq6yes) {
            total += 1;
            radioq6yes.setTextColor(rgb(61,158,20));
        }

        if (hasCheckbox1q7) {
            total += 1;
            checkBox1q7.setTextColor(rgb(61,158,20));
        }

        /** Toast result**/
        String message="";
        if (total >= 6){
            message ="\n   *** Well done! ***\n";
        }else{
            message = "\nTry your best next time!\n";
        }
        Toast.makeText(this, "You got " + total + " out of 8!\n" + message, Toast.LENGTH_LONG).show();

        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setVisibility(View.GONE);
    }

    /** Restarting the app to reset it**/
    public void reset(View view) {
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}

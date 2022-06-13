package com.example.uw_life_simulator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.uw_life_simulator.MainActivity;
import com.example.uw_life_simulator.R;
import com.example.uw_life_simulator.model.Talent;

import org.w3c.dom.Text;

public class TalentActivities extends AppCompatActivity {
    Talent talent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        talent = new Talent(10);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities_talent_selection);
    }

    // update current points we have, parameter
    // increaseOrDecrease = 0 when increase point,
    // increaseOrDecrease = 1 when decrease point
    // this function does not check for the validity of input, it assumes
    // the button click is valid
    private void updatePoint(int increaseOrDecrease, TextView textView1, TextView textView2) {
        int availablePoint = Integer.parseInt(textView1.getText().toString());
        int currentPoint = Integer.parseInt(textView2.getText().toString());

        // if the user hits minus button
        if(increaseOrDecrease == 0) {
            textView1.setText(String.valueOf(++availablePoint));
            textView2.setText(String.valueOf(--currentPoint));
        } else {    // if the user his plus button
            textView1.setText(String.valueOf(--availablePoint));
            textView2.setText(String.valueOf(++currentPoint));
        }
    }

    // increase available point by 1 (when the minus button is hit)
    // this function checks for the validity of input
    private void hitMinusButton(TextView totalAvailablePoint, TextView totalCurrentPoint) {
        int availablePoint = Integer.parseInt(totalAvailablePoint.getText().toString());
        int currentPoint = Integer.parseInt(totalCurrentPoint.getText().toString());
        // check for invalid operation : when available point exceeds limit or
        // current point is zero
        if (availablePoint >= talent.getTotalPoint() || currentPoint < 1) {
            return;
        }
        updatePoint(0,totalAvailablePoint,totalCurrentPoint);
    }


    // decrease available point by 1 (when the plus button is hit)
    // this function checks for the validity of input
    private void hitAddButton(TextView totalAvailablePoint, TextView totalCurrentPoint) {
        int availablePoint = Integer.parseInt(totalAvailablePoint.getText().toString());
        int currentPoint = Integer.parseInt(totalCurrentPoint.getText().toString());
        // check for invalid operation : when available point exceeds limit or
        // current point is zero
        if (availablePoint < 1) {
            return;
        }
        updatePoint(1,totalAvailablePoint,totalCurrentPoint);
    }

    // Increment IQ if the addIQ button is hit
    public void addIQ(View view) {
        /*
        // get current IQ amount
        TextView textView = findViewById(R.id.talentIQAmount);
        String IQString = textView.getText().toString();
        int IQAmount = Integer.parseInt(IQString);
        // increment IQ amount
        IQAmount++;
        textView.setText(String.valueOf(IQAmount));
        */
        System.out.println("PLUS IQ reached");
        // get available point
        TextView totalAvailablePoint = findViewById(R.id.availableTalentAmount);
        // get current point for IQ
        TextView currentIQPoint = findViewById(R.id.talentIQAmount);
        hitAddButton(totalAvailablePoint, currentIQPoint);
    }

    // decrease IQ if the minusIQ button is hit
    public void minusIQ(View view) {
        /*
        // get current IQ amount
        TextView textView = findViewById(R.id.talentIQAmount);
        String IQString = textView.getText().toString();
        int IQAmount = Integer.parseInt(IQString);
        // decrease IQ amount
        IQAmount = Math.max(--IQAmount,0);
        textView.setText(String.valueOf(IQAmount));
         */
        // get available point
        TextView totalAvailablePoint = findViewById(R.id.availableTalentAmount);
        // get current point for IQ
        TextView currentIQPoint = findViewById(R.id.talentIQAmount);
        hitMinusButton(totalAvailablePoint, currentIQPoint);
    }





}
package com.pwcte.anh.pwcte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ComparisonActivity extends AppCompatActivity {

    private Button mNumberOne;
    private Button mNumberTwo;
    private Button mButtonNext;
    private double mNum1;
    private double mNum2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison);

        CustomNumber cN = new CustomNumber();


        //
        mNumberOne = (Button) findViewById(R.id.button);
        mNumberTwo = (Button) findViewById(R.id.button2);
        mButtonNext = (Button) findViewById(R.id.button3);

        //Hide the next button
        mButtonNext.setVisibility(View.INVISIBLE);


        //Set up a number

        // TODO: change the number appropriately for training
        int a = cN.getRandomNumber();
        mNum1 = cN.getSmallNumber(a,3);
        //Set up the second number
        int b = cN.getSecondRandomNumber(a);
        mNum2 = cN.getSmallNumber(b,3);

        //Display the numbers by changing the string
        mNumberOne.setText(String.valueOf(mNum1));
        mNumberTwo.setText(String.valueOf(mNum2));

        mNumberOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mNumberTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new activity
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }

    private void checkAnswer(boolean buttonPressed)
    {
        int messageResId = 0;
        if(mNum1==mNum2)
        {
            messageResId = R.string.Equal;
        }
        if((mNum1 > mNum2 && buttonPressed == true)||(mNum2 > mNum1 && buttonPressed == false))
        {
            messageResId = R.string.Correct;
        }
        else
        {
            messageResId = R.string.Inccorect;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
        mButtonNext.setVisibility(View.VISIBLE);
    }




}

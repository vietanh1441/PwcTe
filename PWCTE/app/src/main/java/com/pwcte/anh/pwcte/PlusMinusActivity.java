package com.pwcte.anh.pwcte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class PlusMinusActivity extends AppCompatActivity {


    private Button mCheck;
    private Button mButtonNext;
    private TextView  mFirstNum, mPoM, mSecondNum;
    private double mNum1;
    private double mNum2;
    boolean mSign;

    private EditText input1;
    //get 2 random number
    // decide plus or minus
    //ask user to do math
    //Check the math
    //if correct, say correct, if not, correct it with the correct answer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus_minus);

        CustomNumber cN = new CustomNumber();

        mFirstNum = (TextView) findViewById(R.id.textView2);
        mPoM = (TextView) findViewById(R.id.textView3);
        mSecondNum = (TextView) findViewById(R.id.textView4);

        mCheck = (Button) findViewById(R.id.check_button);
        mButtonNext = (Button) findViewById(R.id.nextButton);

        //hide NextButton
        mButtonNext.setVisibility(View.INVISIBLE);

        input1 = (EditText) findViewById(R.id.Result);

        //get 2 number
        int a = cN.getRandomNumber();
        mNum1 = cN.getSmallNumber(a,3);
        mFirstNum.setText(String.valueOf(mNum1));

        //Set up the second number
        int b = cN.getSecondRandomNumber(a);
        mNum2 = cN.getSmallNumber(b,3);
        mSecondNum.setText(String.valueOf(mNum2));
        //Get sign of the operation
        mSign = getPoM();
        if(mSign)
        {
            mPoM.setText("+");
        }
        else
        {
            mPoM.setText("-");
        }

        //If User click Check button, then compare user input with actual result

        mCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(input1.getText().toString());
                double n2 = getResult(mNum1, mNum2, mSign);
                checkAnswer(n1,n2);
            }
        });


        //Click Next Button to get to another problem
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

    private void checkAnswer(double n1, double n2)
    {
        int messageResId = 0;
        if(n1 == n2)
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

    private double getResult(double num1, double num2, boolean sign)
    {
        if(sign)
        {
            return num1+num2;
        }
        else
        {
            return num1-num2;
        }
    }


    private boolean getPoM()
    {
        Random rand = new Random();
        int n = rand.nextInt(2);
        if(n == 0) {
            return true;
        }
        else
        {
            return false;
        }
    }


}

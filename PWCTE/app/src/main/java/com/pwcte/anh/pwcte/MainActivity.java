package com.pwcte.anh.pwcte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mCompare_button;
    private Button mCalculate_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mCompare_button = (Button) findViewById(R.id.compare_button);
        mCalculate_button = (Button) findViewById(R.id.calculate_button);

        mCompare_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ComparisonActivity.class));
            }
        });

        mCalculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlusMinusActivity.class));
            }
        });

    }
}

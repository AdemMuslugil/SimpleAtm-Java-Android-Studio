package com.adem.simpleatm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int money = 15000;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView2);    //to determine textview
        textView.setText("Balance " + money); //to assign a value to a textview

    }

    public void withdraw(View view) { //for go to the 'WithdrawMoney' page
        Intent intent = new Intent(MainActivity.this, WithdrawMoney.class);
        intent.putExtra("money", money);
        startActivity(intent);

    }

    public void update(View view) { //for 'Money' update
        Intent intent = getIntent();
        int result = intent.getIntExtra("result", 0);
        money = result;
        textView.setText("Balance " + money);

    }

    public void deposit(View view) { //for go to 'Deposit' page
        Intent intent = new Intent(this, Deposit.class);
        intent.putExtra("money", money);
        startActivity(intent);
    }

    public void exit(View view) {//Exit button
        finish();
        System.exit(0);
    }
}
package com.adem.simpleatm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Deposit extends AppCompatActivity {
    int money;
    TextView textView;
    EditText editText;
    int result;
    int deposit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        //to withdraw the value of money
        Intent intent = getIntent();
        money = intent.getIntExtra("money", 0);


        editText = findViewById(R.id.editTextNumber2);
        textView = findViewById(R.id.textView3);
        textView.setText("Balance " + money);
    }

    public void deposit(View view) {
        deposit = Integer.parseInt(editText.getText().toString());

        if (deposit <= 0) {
            Toast.makeText(this, "Entry Amount", Toast.LENGTH_SHORT).show();
        } else {
            result = money + deposit;
            money = result;
            textView.setText("Balance " + result);
        }

    }

    public void back(View view) {   //when the back button is pressed, the homepage returns and carries the new value of the money
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("result", money);
        startActivity(intent);
    }
}
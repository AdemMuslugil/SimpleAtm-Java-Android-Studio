package com.adem.simpleatm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WithdrawMoney extends AppCompatActivity {
    int money;
    int x;
    int result;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_money);

        editText = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.money);

        //to withdraw the value of money
        Intent intent = getIntent();
        money = intent.getIntExtra("money", 0);

        textView.setText("" + money);
    }

    public void withdraw(View view) {

        x = Integer.parseInt(editText.getText().toString());

        if (x <= 0) {
            Toast.makeText(this, "Entry Amount", Toast.LENGTH_SHORT).show();

        } else {
            result = money - x;
            money = result;
            textView.setText("" + result);
        }
    }

    public void back(View view) {   //when the back button is pressed, the homepage returns and carries the new value of the money
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}
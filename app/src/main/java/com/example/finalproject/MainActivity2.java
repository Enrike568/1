package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

import static com.example.finalproject.R.id.etInput;
import static com.example.finalproject.R.id.radio;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

//TODO: SHA-1,SHA-224,SHA-256,SHA-384,SHA-512

    public void btnSHA(View view) {
        EditText etInput = (EditText) findViewById(R.id.etInput);
        TextView tvOutput = (TextView) findViewById(R.id.tvOutput);

        byte[] inputData = etInput.getText().toString().getBytes();
        byte[] outputData = new byte[0];

        try {
            outputData = sha.encryptSHA(inputData, "SHA-1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    private Object Text;
    private Button encrypt;
    private Object Code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etInput = (EditText) findViewById(R.id.etInput);
        final TextView tvOutput = (TextView) findViewById(R.id.tvOutput);
        encrypt = findViewById(R.id.button);
        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOutput.setText(md5(etInput.getText().toString()));
            }
        });

    }

    public static String md5(final String s) { final String MD5 = "MD5"; try {
        MessageDigest digest = java.security.MessageDigest .getInstance(MD5);
        ((MessageDigest) digest).update(s.getBytes());
        byte messageDigest[] = digest.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte aMessageDigest : messageDigest) { String h = Integer.toHexString(0xFF & aMessageDigest);
            while (h.length() < 2) h = "0" + h; hexString.append(h);
        } return hexString.toString();
    } catch (NoSuchAlgorithmException e) { e.printStackTrace();
    } return "";
    }
}

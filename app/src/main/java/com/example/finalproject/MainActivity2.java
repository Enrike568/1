package com.example.finalproject;

import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity2 extends AppCompatActivity {

    Button button;
    String sha;
    RadioGroup radioGroup;
    RadioButton sha1;
    RadioButton sha224;
    RadioButton sha256;
    RadioButton sha384;
    RadioButton sha512;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        radioGroup = findViewById(R.id.radiogroup);

        final EditText etInput = (EditText) findViewById(R.id.etInput);
        final TextView tvOutput = (TextView) findViewById(R.id.tvOutput);

        sha1 = findViewById(R.id.sha1);
        sha224 = findViewById(R.id.sha224);
        sha256 = findViewById(R.id.sha256);
        sha512 = findViewById(R.id.sha512);
        sha384 = findViewById(R.id.sha384);

        button = findViewById(R.id.button);

        int rgid;

        final String input = etInput.getText().toString();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rgid[0] = checkedId;

            }
        });

        switch (rgid[0]){

            case R.id.sha1:
                sha = "SHA-1";
                break;

            case R.id.sha224:
                sha = "SHA-224";
                break;

            case R.id.sha256:
                sha = "SHA-256";
                break;

            case R.id.sha512:
                sha = "SHA-512";
                break;
            case R.id.sha384:
                sha = "SHA-384";
                break;
            default:
                sha = "SHA-1";
                break;

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("TAGA", "1");
                Log.d("TAGA", sha);
                tvOutput.setText(encryptThisString(input, sha));

                Log.d("TAGA", tvOutput.getText().toString());


            }


        });
    }

    public static String encryptThisString(String input, String sha) {

        try {

            MessageDigest md = MessageDigest.getInstance(sha);

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {

                hashtext = "0" + hashtext;

            }

            return hashtext;

        }

        catch (NoSuchAlgorithmException e) {

            throw new RuntimeException(e);

        }

    }

}




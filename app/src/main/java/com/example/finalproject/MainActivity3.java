package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity3 extends AppCompatActivity {



        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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




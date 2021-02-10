package com.example.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_LOGIN = 0001;
    private static final int REQUEST_SINGUP = 0002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onloginMainClick(View v){
        Intent intent = new Intent(this,Login.class);
        startActivityForResult(intent, REQUEST_LOGIN);

    }

    public void onSignupnMainClick(View v){
        Intent intent = new Intent(this,Register.class);
        startActivityForResult(intent, REQUEST_SINGUP);

    }

}
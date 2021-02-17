package com.example.assigment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Login extends AppCompatActivity {

    private EditText LoginEditText, PasswordEditText;
    private TextView signupButton;

    private FirebaseAuth loginauth;
    private static final int REQUEST_SINGUP = 0002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginEditText = findViewById(R.id.LoginEditText);
        PasswordEditText = findViewById(R.id.PasswordEditText);
        signupButton = findViewById(R.id.signupButton);

        loginauth = FirebaseAuth.getInstance();
    }

    public void onLoginButtonClick(View v){
        String email = LoginEditText.getText().toString();
        String password = PasswordEditText.getText().toString();

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Please fill in the information",
                    Toast.LENGTH_SHORT).show();
        }else{
            loginauth.signInWithEmailAndPassword(email,password);   //@
            if(loginauth.signInWithEmailAndPassword(email,password).isSuccessful()) {
                Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Login.this,Donateplacelist.class));
            }else{
                Toast.makeText(this, "Error",Toast.LENGTH_SHORT).show();
            }

        }
    }


    public void onsignupButtonClick(View v){
        Intent intent = new Intent(this,Register.class);
        startActivityForResult(intent, REQUEST_SINGUP);
    }
}
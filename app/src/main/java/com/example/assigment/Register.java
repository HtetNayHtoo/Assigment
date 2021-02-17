package com.example.assigment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private EditText nameEditText, emailEditText,  passwordEditText,
             repasswordEditText;
    private FirebaseAuth Regauth;
    private Button registerBtn;


    private static final int REQUEST_LOGIN = 0001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        repasswordEditText = findViewById(R.id.repasswordEditText);
        registerBtn = findViewById(R.id.registerButton);

        Regauth = FirebaseAuth.getInstance();
    }


    public void onRegisterButtonClick(View view){
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String repassword = repasswordEditText.getText().toString();
        String name = nameEditText.getText().toString();

        if (email.isEmpty() || password.isEmpty() || repassword.isEmpty() || name.isEmpty()
        ){
            Toast.makeText(Register.this, "Please fill in the information",
                    Toast.LENGTH_SHORT).show();
        }
        else if(password.length() < 6 ){
            Toast.makeText(Register.this,"Password is shorter than 6 digits",
                    Toast.LENGTH_SHORT).show();
        }
        else if(!password.equals(repassword)){
            Toast.makeText(this,"Password doesn't Match !", Toast.LENGTH_SHORT).show();
        }
        else{
            Regauth.createUserWithEmailAndPassword(email,password);
            Toast.makeText(Register.this, "Account Registered!",
                                Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Register.this, Login.class));
            }
        }

    public void onloginButtonClick(View view){
        Intent intent = new Intent(this,Login.class);
        startActivityForResult(intent, REQUEST_LOGIN);
    }


}
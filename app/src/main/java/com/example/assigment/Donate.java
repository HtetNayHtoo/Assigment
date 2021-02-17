package com.example.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class Donate extends AppCompatActivity {
    private EditText realnameEditTextView, phoneEditText, aptimeEditText,
            dateEditText, btypeEdittext;
    private RadioGroup genderRadioGroup;
    private FirebaseDatabase donateDatabase;
    private DatabaseReference donateRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        realnameEditTextView = findViewById(R.id.realnameEditTextView);
        phoneEditText = findViewById(R.id.phoneEditText);
        aptimeEditText = findViewById(R.id.aptimeEditText);
        dateEditText = findViewById(R.id.dateEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        btypeEdittext = findViewById(R.id.btypeEdittext);

        donateDatabase = FirebaseDatabase.getInstance();
    }

    public void onapButtonClick(View view){
        String realname= realnameEditTextView.getText().toString();
        String phone= phoneEditText.getText().toString();
        String aptime = aptimeEditText.getText().toString();
        String apdate = dateEditText.getText().toString();
        String btype = btypeEdittext.getText().toString();

        Date c = Calendar.getInstance().getTime();


        int selectedID = genderRadioGroup.getCheckedRadioButtonId();
        RadioButton genderRadioButton = findViewById(selectedID);
        String gender = genderRadioButton.getText().toString();

        if(realname.isEmpty()||phone.isEmpty()||aptime.isEmpty()||apdate.isEmpty()||gender.isEmpty()
                ||btype.isEmpty()){
            Toast.makeText(this, "Please fill in the information",
                    Toast.LENGTH_SHORT).show();
        }//@
        else if(!apdate.equals("(0?[1-9]|1[012]) [/.-] (0?[1-9]|[12][0-9]|3[01]) " +
                "[/.-] ((21|22)\\d\\d)") || !apdate.equals(c.toString()))
        {
                Toast.makeText(this, "date format should be 0X/0X/21! Can't accept current date", Toast.LENGTH_SHORT).show();
        }
        else if(!"A".equals(btype)||!"B".equals(btype)||!"O".equals(btype)||!"AB".equals(btype)){
            Toast.makeText(this,"Bloodtype doesn't exist!",Toast.LENGTH_SHORT).show(); } //@
          else{
             donateRef = donateDatabase.getReference("DonatedPerson").child(realname);
             donateRef.child("Phone").setValue(phone);
             donateRef.child("AppointmentTime").setValue(aptime);
             donateRef.child("AppointmentDate").setValue(apdate);
             donateRef.child("Gender").setValue(gender);
             donateRef.child("BloodType").setValue(btype);
             Toast.makeText(this,"Thank you for your Donation!", Toast.LENGTH_LONG).show();
        }
    }

    public void btmClick(View view){
        startActivity(new Intent(Donate.this, Donateplacelist.class));
    }
}
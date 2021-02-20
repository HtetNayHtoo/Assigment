package com.example.assigment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Donateplacelist extends AppCompatActivity {

    private ListView infoListView;
    private String[] HospitalNames;
    private String[] Address;
    private String[] ContactNumber;
    private static int[] hospitalPhotos = {
            R.drawable.kty,
            R.drawable.yg,
            R.drawable.sk,
            R.drawable.ay
    };

    private ArrayList<information> informationArrayList = new ArrayList<>();

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_donateplacelist);
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_donateplacelist);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donateplacelist);

        HospitalNames = getResources().getStringArray(R.array.HospitalNames);
        Address = getResources().getStringArray(R.array.Address);
        ContactNumber = getResources().getStringArray(R.array.ContactNumber);

        generateInformation();

        infoListView = findViewById(R.id.infoList);
        infoListView.setAdapter(new InformationViewAdapter(this, R.layout.informationview,
                informationArrayList));
    }

    private void generateInformation() {
        for (int i =0; i< hospitalPhotos.length; i++){
            information info = new information(HospitalNames[i],Address[i],ContactNumber[i],
                    hospitalPhotos[i]);
            informationArrayList.add(info);
        }
    }

    public void onLogoutButtonClick(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, MainActivity.class));
    }

    public void onDonateClick(View view){
        startActivity(new Intent(this,Donate.class));
    }
}
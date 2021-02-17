package com.example.assigment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class InformationViewAdapter extends ArrayAdapter<information> {
    private int resources;
    private ArrayList<information> informationArrayList ;
    private  Context context;

    public InformationViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<information> infoList) {
        super(context, resource, infoList);
        this.context = context;
        this.resources = resource;
        this.informationArrayList = infoList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;


        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(resources, parent, false);
        }

        ImageView himage = view.findViewById(R.id.himage);
        TextView hnameTextView = view.findViewById(R.id.hnameTextView);
        TextView addressTextView = view.findViewById(R.id.addressTextView);
        TextView contactTextView = view.findViewById(R.id.contactTextView);

        information info = informationArrayList.get(position);
        himage.setImageResource(info.getPhoto());
        hnameTextView.setText(info.getHname());
        addressTextView.setText(info.getAddress());
        contactTextView.setText(info.getContact());

        return view;
    }
}

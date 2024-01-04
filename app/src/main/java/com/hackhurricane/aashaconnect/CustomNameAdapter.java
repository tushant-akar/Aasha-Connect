package com.hackhurricane.aashaconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Date;

public class CustomNameAdapter extends ArrayAdapter<String> {

    private final Context context;
    private String[] name;
    private int[] UID;
    LinearLayout list;
    String S = "";

    public CustomNameAdapter(@NonNull Context context, int resource, @NonNull String[] name, @NonNull int[] dob) {
        super(context, resource , name);
        this.context = context;
        this.name = name;
        this.UID = dob;
    }

    @Nullable
    @Override
    public String getItem(int position){
        return name[position];}

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_name_list_adapter,parent,false);

//        Date CurrentDate = new Date();
//        Date D = UID[position];
//        LocalDate local = D.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        String year = Integer.toString(local.getYear());
//        String month = local.getMonth().name();
//        String day = "";
//        if(local.getDayOfMonth()<=9){
//            day = "0"+ local.getDayOfMonth();
//        }else{
//            day = Integer.toString(local.getDayOfMonth());
//        }
//        S = day+"-"+month+"-"+year;

        TextView T1 = convertView.findViewById(R.id.Name);
        TextView T2 = convertView.findViewById(R.id.UID);
        LinearLayout L=convertView.findViewById(R.id.linearLayout);

//        if(UID[position].compareTo(CurrentDate)>0){
//            L.setBackgroundColor(Color.parseColor("#eb5c52"));
//        }

        T1.setText(name[position]);
        T2.setText("UID : "+ UID[position]);

        return convertView;
    }

}
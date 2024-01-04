package com.hackhurricane.aashaconnect;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public class DBHandlerPregnantWoman extends SQLiteOpenHelper {

    public DBHandlerPregnantWoman(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE PregnantWomanData (UID INTEGER PRIMARY KEY, Name TEXT, DOB TEXT, Status TEXT, BloodGroup TEXT, HusbandName Text, Vaccine11 TEXT, Vaccine12 TEXT, Vaccine13 TEXT, Vaccine14 TEXT, Vaccine15 TEXT, Vaccine16 TEXT, Vaccine21 TEXT, Vaccine22 TEXT, Vaccine23 TEXT, Vaccine24 TEXT, Vaccine25 TEXT, Vaccine26 TEXT, Vaccine31 TEXT, Vaccine32 TEXT, Vaccine33 TEXT, Vaccine34 TEXT, Vaccine35 TEXT, Vaccine36 TEXT, Vaccine41 TEXT, Vaccine42 TEXT, Vaccine43 TEXT, Vaccine44 TEXT, Vaccine45 TEXT, Vaccine46 TEXT, Height TEXT, Weight TEXT, Hemoglobin TEXT, BP TEXT, Urine TEXT, Abdomen TEXT)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String upgrade = String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(upgrade, new String[]{"PregnantWomanData"});
    }

    public void AddPregnantWomanDetail(classPregnantWoman C){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("UID",C.getUID());
        values.put("Name",C.getName());
        values.put("DOB", C.getDateOfBirth());
        values.put("Status", "Visible");
        values.put("BloodGroup",C.getBloodGroup());
        values.put("HusbandName",C.getHusbandName());

        values.put("Vaccine11", (String) null);
        values.put("Vaccine12", (String) null);
        values.put("Vaccine13", (String) null);
        values.put("Vaccine14", (String) null);
        values.put("Vaccine15", (String) null);
        values.put("Vaccine16", (String) null);

        values.put("Vaccine21", (String) null);
        values.put("Vaccine22", (String) null);
        values.put("Vaccine23", (String) null);
        values.put("Vaccine24", (String) null);
        values.put("Vaccine25", (String) null);
        values.put("Vaccine26", (String) null);

        values.put("Vaccine31", (String) null);
        values.put("Vaccine32", (String) null);
        values.put("Vaccine33", (String) null);
        values.put("Vaccine34", (String) null);
        values.put("Vaccine35", (String) null);
        values.put("Vaccine36", (String) null);

        values.put("Vaccine41", (String) null);
        values.put("Vaccine42", (String) null);
        values.put("Vaccine43", (String) null);
        values.put("Vaccine44", (String) null);
        values.put("Vaccine45", (String) null);
        values.put("Vaccine46", (String) null);

        values.put("Height",(String) null);
        values.put("Weight",(String) null);
        values.put("Hemoglobin", (String) null);
        values.put("BP", (String) null);
        values.put("Urine", (String) null);
        values.put("Abdomen", (String) null);

        long check = db.insert("PregnantWomanData",null,values);
        Log.d("Input Check Tag",Long.toString(check));
        db.close();
    }

    @SuppressLint("Range")
    public Object[] RetrieveAllDetailsPregnantWomanData(){
        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM PregnantWomanData WHERE Status='Visible'",null);
        Cursor cursor = db.rawQuery("SELECT * FROM PregnantWomanData WHERE Status='Visible'",null);
        int count = cursor.getCount();
        int[] UIDArray = new int[count];
        String[] Name = new String[count];
        String[] DOB = new String[count];
        int i=0;
        if(cursor.moveToFirst()){
            do{
                UIDArray[i] = cursor.getInt(cursor.getColumnIndex("UID"));
                Name[i] = cursor.getString(cursor.getColumnIndex("Name"));
                DOB[i] = cursor.getString(cursor.getColumnIndex("DOB"));
                String allString = UIDArray[i]+" - "+Name[i]+" - "+DOB[i];
                Log.d("Tag All",allString);
                i++;
            }while (cursor.moveToNext());
        }
        Object[] arrayToReturn = {UIDArray,Name,DOB};
        Log.d("Hello", Arrays.toString(UIDArray));
        Log.d("Hello2", String.valueOf(getSizePregnantWomanData()));
        cursor.close();
        db.close();
        return arrayToReturn;
    }

    public int getSizePregnantWomanData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM PregnantWomanData WHERE Status='Visible'",null);
        return cursor.getCount();
    }

    @SuppressLint("Range")
    public String getLastUIDValuePregnantWomanData(){
        int toReturn = 1;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("Select * from PregnantWomanData",null);
            int count = cursor.getCount();
            int[] UIDArray = new int[count];
            int i=0;
            if(cursor.moveToFirst()){
                do{
                    UIDArray[i] = cursor.getInt(cursor.getColumnIndex("UID"));
                }while (cursor.moveToNext());
            }
            toReturn = UIDArray[i]+1;
            Log.d("Return tag",Integer.toString(toReturn));
            Log.d("Return UID tag", Arrays.toString(UIDArray));
        }catch (Exception e){
            Log.d("Error Tag Last UID","ERROR");
        }
        return Integer.toString(toReturn);
    }

    public String[] EachUserGetPregnantWomanData(int UID){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("PregnantWomanData",new String[]{"UID","Name","DOB","BloodGroup","HusbandName","Vaccine11","Vaccine12","Vaccine13","Vaccine14","Vaccine15","Vaccine16","Vaccine21","Vaccine22","Vaccine23","Vaccine24","Vaccine25","Vaccine26","Vaccine31","Vaccine32","Vaccine33","Vaccine34","Vaccine35","Vaccine36","Vaccine41","Vaccine42","Vaccine43","Vaccine44","Vaccine45","Vaccine46","Height","Weight","Hemoglobin","BP","Urine","Abdomen"},"UID=? AND Status=?", new String[]{String.valueOf(UID),"Visible"},null,null,null);
        if(cursor!=null && cursor.moveToFirst()){
            Log.d("Tag Name",cursor.getString(1));
            Log.d("Tag DOB",cursor.getString(2));
        }else {
            Log.d("Tag Print","Output Error");
        }
        return new String[]{cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getString(12),cursor.getString(13),cursor.getString(14),cursor.getString(15), cursor.getString(16), cursor.getString(17),cursor.getString(18),cursor.getString(19),cursor.getString(20),cursor.getString(21),cursor.getString(22),cursor.getString(23),cursor.getString(24),cursor.getString(25),cursor.getString(26),cursor.getString(27),cursor.getString(28),cursor.getString(29),cursor.getString(30),cursor.getString(31),cursor.getString(32),cursor.getString(33),cursor.getString(34)};
    }

    public void DeletePregnantWomanData(int UID){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Status","Invisible");
        db.update("PregnantWomanData",contentValues,"UID=?",new String[]{String.valueOf(UID)});
    }

//    public void UpdateNamePregnantWomanData(int UID, String Name){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Name",Name);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateDOBPregnantWomanData(int UID, String DOB){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("DOB",DOB);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateHusbandNamePregnantWomanData(int UID, String MotherName){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("HusbandName",MotherName);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateBloodPregnantWomanData(int UID, String Blood){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("BloodGroup",Blood);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine11PregnantWomanData(int UID, String Vaccine11){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine11",Vaccine11);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine12PregnantWomanData(int UID, String Vaccine12){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine12",Vaccine12);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine13PregnantWomanData(int UID, String Vaccine13){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine13",Vaccine13);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine14PregnantWomanData(int UID, String Vaccine14){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine14",Vaccine14);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine15PregnantWomanData(int UID, String Vaccine15){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine15",Vaccine15);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine16PregnantWomanData(int UID, String Vaccine16){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine16",Vaccine16);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine21PregnantWomanData(int UID, String Vaccine21){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine21",Vaccine21);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine22PregnantWomanData(int UID, String Vaccine22){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine22",Vaccine22);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine23PregnantWomanData(int UID, String Vaccine23){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine23",Vaccine23);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine24PregnantWomanData(int UID, String Vaccine24){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine24",Vaccine24);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine25PregnantWomanData(int UID, String Vaccine25){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine25",Vaccine25);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine26PregnantWomanData(int UID, String Vaccine26){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine26",Vaccine26);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine31PregnantWomanData(int UID, String Vaccine31){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine31",Vaccine31);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine32PregnantWomanData(int UID, String Vaccine32){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine32",Vaccine32);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine33PregnantWomanData(int UID, String Vaccine33){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine33",Vaccine33);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine34PregnantWomanData(int UID, String Vaccine34){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine34",Vaccine34);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine35PregnantWomanData(int UID, String Vaccine35){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine35",Vaccine35);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine36PregnantWomanData(int UID, String Vaccine36){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine36",Vaccine36);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine41PregnantWomanData(int UID, String Vaccine41){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine41",Vaccine41);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine42PregnantWomanData(int UID, String Vaccine42){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine42",Vaccine42);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine43PregnantWomanData(int UID, String Vaccine43){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine43",Vaccine43);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine44PregnantWomanData(int UID, String Vaccine44){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine44",Vaccine44);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine45PregnantWomanData(int UID, String Vaccine45){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine45",Vaccine45);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateVaccine46PregnantWomanData(int UID, String Vaccine46){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Vaccine46",Vaccine46);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateHeightPregnantWomanData(int UID, String Height){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Height",Height);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }
//
//    public void UpdateWeightPregnantWomanData(int UID, String Weight){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValue = new ContentValues();
//        contentValue.put("Weight",Weight);
//        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
//    }

    public void UpdateValue(int UID, String ColumnName, String ColumnValue){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(ColumnName,ColumnValue);
        db.update("PregnantWomanData",contentValue,"UID=?",new String[]{String.valueOf(UID)});
    }

    public ArrayList<classPregnantWoman> getAllUserForExcel(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<classPregnantWoman>list=new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from PregnantWomanData",null);
        if(cursor.moveToFirst()){
            do{
                @SuppressLint("Range") int UID=cursor.getInt(cursor.getColumnIndex("UID"));
                @SuppressLint("Range") String Name=cursor.getString(cursor.getColumnIndex("Name"));
                @SuppressLint("Range") String DOB=cursor.getString(cursor.getColumnIndex("DOB"));
                @SuppressLint("Range") String HusbandName=cursor.getString(cursor.getColumnIndex("HusbandName"));
                @SuppressLint("Range") String BloodGroup=cursor.getString(cursor.getColumnIndex("BloodGroup"));
                @SuppressLint("Range") String Status=cursor.getString(cursor.getColumnIndex("Status"));

                @SuppressLint("Range") String Vaccine11=cursor.getString(cursor.getColumnIndex("Vaccine11"));
                @SuppressLint("Range") String Vaccine12=cursor.getString(cursor.getColumnIndex("Vaccine12"));
                @SuppressLint("Range") String Vaccine13=cursor.getString(cursor.getColumnIndex("Vaccine13"));
                @SuppressLint("Range") String Vaccine14=cursor.getString(cursor.getColumnIndex("Vaccine14"));
                @SuppressLint("Range") String Vaccine15=cursor.getString(cursor.getColumnIndex("Vaccine15"));
                @SuppressLint("Range") String Vaccine16=cursor.getString(cursor.getColumnIndex("Vaccine16"));

                @SuppressLint("Range") String Vaccine21=cursor.getString(cursor.getColumnIndex("Vaccine21"));
                @SuppressLint("Range") String Vaccine22=cursor.getString(cursor.getColumnIndex("Vaccine22"));
                @SuppressLint("Range") String Vaccine23=cursor.getString(cursor.getColumnIndex("Vaccine23"));
                @SuppressLint("Range") String Vaccine24=cursor.getString(cursor.getColumnIndex("Vaccine24"));
                @SuppressLint("Range") String Vaccine25=cursor.getString(cursor.getColumnIndex("Vaccine25"));
                @SuppressLint("Range") String Vaccine26=cursor.getString(cursor.getColumnIndex("Vaccine26"));

                @SuppressLint("Range") String Vaccine31=cursor.getString(cursor.getColumnIndex("Vaccine31"));
                @SuppressLint("Range") String Vaccine32=cursor.getString(cursor.getColumnIndex("Vaccine32"));
                @SuppressLint("Range") String Vaccine33=cursor.getString(cursor.getColumnIndex("Vaccine33"));
                @SuppressLint("Range") String Vaccine34=cursor.getString(cursor.getColumnIndex("Vaccine34"));
                @SuppressLint("Range") String Vaccine35=cursor.getString(cursor.getColumnIndex("Vaccine35"));
                @SuppressLint("Range") String Vaccine36=cursor.getString(cursor.getColumnIndex("Vaccine36"));

                @SuppressLint("Range") String Vaccine41=cursor.getString(cursor.getColumnIndex("Vaccine41"));
                @SuppressLint("Range") String Vaccine42=cursor.getString(cursor.getColumnIndex("Vaccine42"));
                @SuppressLint("Range") String Vaccine43=cursor.getString(cursor.getColumnIndex("Vaccine43"));
                @SuppressLint("Range") String Vaccine44=cursor.getString(cursor.getColumnIndex("Vaccine44"));
                @SuppressLint("Range") String Vaccine45=cursor.getString(cursor.getColumnIndex("Vaccine45"));
                @SuppressLint("Range") String Vaccine46=cursor.getString(cursor.getColumnIndex("Vaccine46"));

                list.add(new classPregnantWoman(UID,Name,BloodGroup,HusbandName,DOB,Status,Vaccine11,Vaccine12,Vaccine13,Vaccine14,Vaccine15,Vaccine16,Vaccine21,Vaccine22,Vaccine23,Vaccine24,Vaccine25,Vaccine26,Vaccine31,Vaccine32,Vaccine33,Vaccine34,Vaccine35,Vaccine36,Vaccine41,Vaccine42,Vaccine43,Vaccine44,Vaccine45,Vaccine46));
//                list.add(new classPregnantWoman(001 ,"Shrimohan","31-05-03","B+","Rajesh"));
            }while (cursor.moveToNext());
        }
        return list;
    }
}

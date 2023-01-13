package com.example.myapplication;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Show_Visits extends Activity {
    ListView listView;

    ArrayList<String> sName = new ArrayList<String>();
    ArrayList<String> addNo=  new ArrayList<String>();
    ArrayList<String> vistDate=  new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_visit);
        DBHandler dbHandler = new DBHandler(this);
        Cursor cursor =  dbHandler.fetch();

        while(cursor.moveToNext()) {
            int index;
            index = cursor.getColumnIndexOrThrow("studentName");

            String firstName = cursor.getString(index);
            String addMissionNo = cursor.getString(cursor.getColumnIndexOrThrow("addmissionNo"));
            String visitDate = cursor.getString(cursor.getColumnIndexOrThrow("visitDate"));
            sName.add(firstName);
            addNo.add(addMissionNo);
            vistDate.add(visitDate);

        }



    listView = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),sName,addNo,vistDate);
        listView.setAdapter(customAdapter);

    }
}
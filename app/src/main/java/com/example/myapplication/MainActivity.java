package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addVisitBtn = (Button) findViewById(R.id.addVisitbtn);
        Button adminLoginBtn = (Button) findViewById(R.id.adminLoginbtn);
        addVisitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AddVisitPage.class);
                startActivity(intent);

            }
        });

        adminLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AdminLogin.class);
                startActivity(intent);
            }
        });

        DBHandler dbHandler = new DBHandler(this);
        Cursor cursor =  dbHandler.fetch();

        while(cursor.moveToNext()) {
            int index;
            try {
                index = cursor.getColumnIndexOrThrow("studentName");
                String firstName = cursor.getString(index);
                Log.d("DATABASE", firstName);
            }catch (Exception e){
                Log.e("DATABASE_ERROR", "onCreate: ",e );
            }

        }



    }
}

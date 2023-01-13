package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddVisitPage extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText studentName, admissionNo, classs, course;
    private Button addCourseBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_visit);

        // initializing all our variables.
        studentName = findViewById(R.id.name);
        admissionNo = findViewById(R.id.addmissionNo);
        classs = findViewById(R.id.idclass);
        course = findViewById(R.id.idCourse);
        addCourseBtn = findViewById(R.id.idAddVisit);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(AddVisitPage.this);

        // below line is to add on click listener for our add course button.
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String studentNameTxt = studentName.getText().toString();
                String addmissionNoTxt = admissionNo.getText().toString();
                String classsTxt = classs.getText().toString();
                String courseTxt = course.getText().toString();


                // validating if the text fields are empty or not.
                if (studentNameTxt.isEmpty() && addmissionNoTxt.isEmpty() && classsTxt.isEmpty() && courseTxt.isEmpty()) {
                    Toast.makeText(AddVisitPage.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addLog(studentNameTxt, addmissionNoTxt, classsTxt, courseTxt);

                // after adding the data we are displaying a toast message.
                Toast.makeText(AddVisitPage.this, "Log has been added.", Toast.LENGTH_SHORT).show();
                studentName.setText("");
                classs.setText("");
                admissionNo.setText("");
                course.setText("");
                Intent intent = new Intent(AddVisitPage.this,MainActivity.class);
                intent.putExtra("sname",studentNameTxt);
                intent.putExtra("cadd",addmissionNoTxt);
                startActivity(intent);
            }
        });
    }
}

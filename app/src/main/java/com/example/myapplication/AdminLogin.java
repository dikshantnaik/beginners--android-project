package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminLogin extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);
        Button btn = (Button) findViewById(R.id.adminLogin);
        EditText usernameObj = (EditText) findViewById(R.id.usernameId);
        EditText passwordObj = (EditText) findViewById(R.id.passwordId);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameObj.getText().toString();
                String password = passwordObj.getText().toString();
                if(username.equals("Admin")&&password.equals("admin")){

                    startActivity(new Intent(new Intent(AdminLogin.this, Show_Visits.class)));
                }else{
                    Toast.makeText(getApplicationContext(),"Wrong Credential",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

package com.example.parth_c0766346_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn = findViewById(R.id.addEmp);


    }

    public void addNewEmployee(View v){

        Intent iAdd = new Intent(MainActivity.this, Registration.class);
        startActivity(iAdd);
    }
}

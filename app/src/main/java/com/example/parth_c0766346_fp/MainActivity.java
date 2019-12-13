package com.example.parth_c0766346_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addBtn;
    ListView allEmpList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn = findViewById(R.id.addEmp);
        allEmpList = findViewById(R.id.empList);

        ArrayList<String> nameID = new ArrayList<>();

        for (Employee e:
                Employee.allEmpInformation) {
            nameID.add(e.showNameId());
        }


        ArrayAdapter<String> empAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nameID);
        allEmpList.setAdapter(empAdapter);
        empAdapter.notifyDataSetChanged();


    }

    public void addNewEmployee(View v){

        Intent iAdd = new Intent(MainActivity.this, Registration.class);
        startActivity(iAdd);
    }
}

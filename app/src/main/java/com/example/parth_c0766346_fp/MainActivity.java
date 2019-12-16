package com.example.parth_c0766346_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addBtn;
    ListView allEmpList;
    SearchView srch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn = findViewById(R.id.addEmp);
        allEmpList = findViewById(R.id.empList);
        srch = findViewById(R.id.searchbar);


        ArrayList<String> nameID = new ArrayList<>();

        for (Employee e:
                Employee.allEmpInformation) {
            nameID.add(e.showNameId());
        }

        System.out.println(nameID);
        final ArrayAdapter<String> empAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nameID);
        allEmpList.setAdapter(empAdapter);
        empAdapter.notifyDataSetChanged();


        allEmpList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent d = new Intent(MainActivity.this, Description.class);
                System.out.println("inside function");
                System.out.println(Employee.allEmpInformation.get(position).toString());
                d.putExtra("allInfo", Employee.allEmpInformation.get(position).toString());
                startActivity(d);
            }
        });


        srch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                empAdapter.getFilter().filter(newText);
                return false;
            }
        });


    }

    public void addNewEmployee(View v){

        Intent iAdd = new Intent(MainActivity.this, Registration.class);
        startActivity(iAdd);
    }
}

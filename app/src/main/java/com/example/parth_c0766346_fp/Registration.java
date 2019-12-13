package com.example.parth_c0766346_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    RadioGroup vehicle_type, sidecar;
    EditText make, plate, type, noOfTask, eFname, eLname, bYear, mSalary, oRate, empid;
    Spinner color, employeePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        make = findViewById(R.id.model);
        plate = findViewById(R.id.plateNumber);
        color = findViewById(R.id.vehicleColor);
        sidecar = findViewById(R.id.sideCar);
        vehicle_type = findViewById(R.id.vehicleType);
        employeePosition = findViewById(R.id.employeeType);
        noOfTask = findViewById(R.id.taskDone);
        type = findViewById(R.id.carType);

        eFname = findViewById(R.id.firstName);
        eLname = findViewById(R.id.lastName);
        bYear = findViewById(R.id.birthYear);
        mSalary = findViewById(R.id.monthlySalary);
        oRate = findViewById(R.id.occupationRate);
        empid = findViewById(R.id.employeeId);

        employeePosition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public void registerEmployee(View v){


        Vehicle empV;
        System.out.println("stage 1");
        switch (vehicle_type.getCheckedRadioButtonId()){


            case R.id.car:
                empV = new Car(make.getText().toString(), plate.getText().toString(), color.getSelectedItem().toString(), type.getText().toString());
                break;
            default:
                Boolean haveSidecar = false;

                switch(sidecar.getCheckedRadioButtonId()){
                    case R.id.yes: haveSidecar = true; break;
                    default: haveSidecar = false; break;
                }

                empV = new Motorbike(make.getText().toString(), plate.getText().toString(), color.getSelectedItem().toString(), haveSidecar);
                break;

        }
        System.out.println("stage 2");

        Employee newEmp;
        switch (employeePosition.getSelectedItem().toString()){
            case "Manager":
                newEmp = new Manager(eFname.getText().toString(),Integer.parseInt(empid.getText().toString()), Integer.parseInt(bYear.getText().toString()),
                        Double.parseDouble(mSalary.getText().toString()), Double.parseDouble(oRate.getText().toString()), empV, Integer.parseInt(noOfTask.getText().toString()));
                break;
            case "Programmer":
                newEmp = new Programmer(eFname.getText().toString(),Integer.parseInt(empid.getText().toString()), Integer.parseInt(bYear.getText().toString()),
                        Double.parseDouble(mSalary.getText().toString()), Double.parseDouble(oRate.getText().toString()), empV, Integer.parseInt(noOfTask.getText().toString()));
                break;

            case "Tester":
                newEmp = new Tester(eFname.getText().toString(),Integer.parseInt(empid.getText().toString()), Integer.parseInt(bYear.getText().toString()),
                        Double.parseDouble(mSalary.getText().toString()), Double.parseDouble(oRate.getText().toString()), empV, Integer.parseInt(noOfTask.getText().toString()));
                break;
            default:
                newEmp = new Employee(eFname.getText().toString(),Integer.parseInt(empid.getText().toString()), Integer.parseInt(bYear.getText().toString()),
                        Double.parseDouble(mSalary.getText().toString()), Double.parseDouble(oRate.getText().toString()), empV);

        }
        System.out.println("stage 3");

        Employee.allEmpInformation.add(newEmp);
        Toast.makeText(this, "Congratulations !! Employee is registered successfully !!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Registration.this, MainActivity.class);
        System.out.println("stage 4");

        startActivity(i);


    }
}

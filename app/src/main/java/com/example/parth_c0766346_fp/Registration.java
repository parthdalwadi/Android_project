package com.example.parth_c0766346_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    RadioGroup vehicle_type, sidecar;
    EditText make, plate, type, noOfTask, eFname, eLname, bYear, mSalary, oRate, empid;
    Spinner color, employeePosition;
    TextView tasklabel;
    TableRow veh_type, car_type, side_car;

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
        tasklabel = findViewById(R.id.taskLabel);
        veh_type = findViewById(R.id.rVtype);
        car_type = findViewById(R.id.rCtype);
        side_car = findViewById(R.id.rSide);

        employeePosition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String dasignation;
                switch (position) {

                    case 1:
                        dasignation = "# clients ";
                        veh_type.setVisibility(View.VISIBLE);

                        break;
                    case 2:
                        dasignation = "# bugs";
                        veh_type.setVisibility(View.VISIBLE);

                        break;
                    case 3:
                        dasignation = "# projects";
                        veh_type.setVisibility(View.VISIBLE);

                        break;
                    default:
                        dasignation = "# tasks";

                        veh_type.setVisibility(View.GONE);
                        car_type.setVisibility(View.GONE);
                        side_car.setVisibility(View.GONE);
                        break;
                }

                tasklabel.setText(dasignation);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    public void onVehicleSelect(View v) {

        switch (v.getId()) {

            case R.id.car:
                car_type.setVisibility(View.VISIBLE);
                side_car.setVisibility(View.GONE);
                break;
            case R.id.moto:
                car_type.setVisibility(View.GONE);
                side_car.setVisibility(View.VISIBLE);
                break;
            default:
                car_type.setVisibility(View.GONE);
                side_car.setVisibility(View.GONE);
                break;
        }

    }

    public void registerEmployee(View v) {

        Boolean fn, ln, by, ms, or, id, tsk, mdl, pno, col, empT;

        fn = eFname.getText().toString().isEmpty();
        ln = eLname.getText().toString().isEmpty();
        by = bYear.getText().toString().isEmpty();
        ms = mSalary.getText().toString().isEmpty();
        or = oRate.getText().toString().isEmpty();
        id = empid.getText().toString().isEmpty();
        mdl = make.getText().toString().isEmpty();
        pno = plate.getText().toString().isEmpty();
        col = (color.getSelectedItemPosition() == 0);
        empT = (employeePosition.getSelectedItemPosition() == 0);

        if (fn || ln || by || ms || or || id || mdl || pno || col || empT) {

            Toast.makeText(this, "Please provide all the details", Toast.LENGTH_SHORT).show();


            // also check for unique ID
        } else {


            Boolean empIDExists = false;

            for (Employee emp :
                    Employee.allEmpInformation) {

                if (emp.getId() == Integer.parseInt(empid.getText().toString())) {

                    empIDExists = true;
                    Toast.makeText(this, "Employee ID already Exists", Toast.LENGTH_SHORT).show();
                    break;

                }

            }

            if (!empIDExists) {

                Vehicle empV;
                System.out.println("stage 1");
                switch (vehicle_type.getCheckedRadioButtonId()) {


                    case R.id.car:
                        empV = new Car(make.getText().toString(), plate.getText().toString(), color.getSelectedItem().toString(), type.getText().toString());
                        break;
                    default:
                        Boolean haveSidecar = false;

                        switch (sidecar.getCheckedRadioButtonId()) {
                            case R.id.yes:
                                haveSidecar = true;
                                break;
                            default:
                                haveSidecar = false;
                                break;
                        }

                        empV = new Motorbike(make.getText().toString(), plate.getText().toString(), color.getSelectedItem().toString(), haveSidecar);
                        break;

                }
                System.out.println("stage 2");

                Employee newEmp;
                switch (employeePosition.getSelectedItem().toString()) {
                    case "Manager":
                        newEmp = new Manager(eFname.getText().toString()+ " " +eLname.getText().toString(), Integer.parseInt(empid.getText().toString()), Integer.parseInt(bYear.getText().toString()),
                                Double.parseDouble(mSalary.getText().toString()), Integer.parseInt(oRate.getText().toString()), empV, Integer.parseInt(noOfTask.getText().toString()));
                        break;
                    case "Programmer":
                        newEmp = new Programmer(eFname.getText().toString()+" " + eLname.getText().toString(), Integer.parseInt(empid.getText().toString()), Integer.parseInt(bYear.getText().toString()),
                                Double.parseDouble(mSalary.getText().toString()), Integer.parseInt(oRate.getText().toString()), empV, Integer.parseInt(noOfTask.getText().toString()));
                        break;

                    case "Tester":
                        newEmp = new Tester(eFname.getText().toString() +" " + eLname.getText().toString(), Integer.parseInt(empid.getText().toString()), Integer.parseInt(bYear.getText().toString()),
                                Double.parseDouble(mSalary.getText().toString()), Integer.parseInt(oRate.getText().toString()), empV, Integer.parseInt(noOfTask.getText().toString()));
                        break;
                    default:
                        newEmp = new Employee(eFname.getText().toString()+ " " +eLname.getText().toString(), Integer.parseInt(empid.getText().toString()), Integer.parseInt(bYear.getText().toString()),
                                Double.parseDouble(mSalary.getText().toString()), Integer.parseInt(oRate.getText().toString()), empV);

                }
                System.out.println("stage 3");

                Employee.allEmpInformation.add(newEmp);
                Toast.makeText(this, "Congratulations !! Employee is registered successfully !!", Toast.LENGTH_SHORT).show();
                // replace with dialoge box
                Intent i = new Intent(Registration.this, MainActivity.class);
                System.out.println("stage 4");
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }


        }
    }
}
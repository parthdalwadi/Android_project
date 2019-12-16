package com.example.parth_c0766346_fp;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Employee {

    private String name;
    private int age, birthYear, id, rate;
    private double monthlySalary;
    private Vehicle empVehicle;

    public Employee(String name, int id, int birthYear, double monthlySalary, int rate, Vehicle empVehicle) {
        this.name = name;
        this.id = id;
        this.birthYear = birthYear;
        this.age = 2019 - birthYear;
        this.monthlySalary = monthlySalary;

        if (rate < 10){
            this.rate = rate;
        }
        else if (rate > 100) {

            this.rate = 100;
        }
        else{
            this.rate = rate;
        }
        this.empVehicle = empVehicle;
    }

    public static ArrayList<Employee> allEmpInformation = new ArrayList<>();

    public double annualIncome(){

        return (monthlySalary*12*rate)/100;
    }

    @NonNull
    @Override
    public String toString() {
        String des =  String.format("Name: %s,A %s\n Age: %d\n", name, getDesignation(), age);
        String veh = empVehicle.toString();
        String info = String.format("\nOccupation rate: %02d\n Annual Income is : $ %.2f \n",
                rate, annualIncome());

        return des + veh + info;

    }

    public int getId(){
        return id;
    }
    public String getDesignation(){
        return "Employee";
    }

    public String showNameId(){
        return String.format("Name: %s\nID: %d", name, id);
    }
}

package com.example.parth_c0766346_fp;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Employee {

    private String name;
    private int age, birthYear, id;
    private double monthlySalary, rate;
    private Vehicle empVehicle;

    public Employee(String name, int id, int birthYear, double monthlySalary, double rate, Vehicle empVehicle) {
        this.name = name;
        this.id = id;
        this.birthYear = birthYear;
        this.age = 2019 - birthYear;
        this.monthlySalary = monthlySalary;
        this.rate = rate;
        this.empVehicle = empVehicle;
    }

    public static ArrayList<Employee> allEmpInformation = new ArrayList<>();

    public double annualIncome(){

        return monthlySalary*12;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public String showNameId(){
        return String.format("Name: %s\nID: %d", name, id);
    }
}

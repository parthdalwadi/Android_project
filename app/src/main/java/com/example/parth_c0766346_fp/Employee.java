package com.example.parth_c0766346_fp;

import java.util.ArrayList;

public class Employee {

    private String name;
    private int age, birthYear;
    private double monthlySalary, rate;
    private Vehicle empVehicle;

    public Employee(String name, int birthYear, double monthlySalary, double rate, Vehicle empVehicle) {
        this.name = name;
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

}

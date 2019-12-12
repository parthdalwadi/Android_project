package com.example.parth_c0766346_fp;

public class Tester extends Employee {

    int nbBugs;

    public Tester(String name, int birthYear, double monthlySalary, double rate, Vehicle empVehicle, int nbBugs) {
        super(name, birthYear, monthlySalary, rate, empVehicle);
        this.nbBugs = nbBugs;
    }
}

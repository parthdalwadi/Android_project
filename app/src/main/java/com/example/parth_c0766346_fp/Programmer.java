package com.example.parth_c0766346_fp;

import androidx.annotation.NonNull;

public class Programmer extends Employee {

    private final int GAIN_FACTOR_PROJECTS = 200;
    private int nbProjects;

    public Programmer(String name, int id, int birthYear, double monthlySalary, int rate, Vehicle empVehicle, int nbProjects) {
        super(name, id, birthYear, monthlySalary, rate, empVehicle);
        this.nbProjects = nbProjects;
    }

    @Override
    public double annualIncome() {
        return super.annualIncome() + (nbProjects*GAIN_FACTOR_PROJECTS);
    }

    @Override
    public String getDesignation() {
        return "Programmer";
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + String.format("He/She has completed %d projects.", nbProjects );
    }
}

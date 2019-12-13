package com.example.parth_c0766346_fp;

import androidx.annotation.NonNull;

public class Tester extends Employee {
    private final int GAIN_FACTOR_ERROR = 10;
    int nbBugs;

    public Tester(String name, int id, int birthYear, double monthlySalary, double rate, Vehicle empVehicle, int nbBugs) {
        super(name, id, birthYear, monthlySalary, rate, empVehicle);
        this.nbBugs = nbBugs;
    }

    @Override
    public double annualIncome() {
        return super.annualIncome() + (nbBugs*GAIN_FACTOR_ERROR);
    }

    @Override
    public String getDesignation() {
        return "Tester";
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + String.format("He/She has corrected %d bugs.", nbBugs );
    }
}

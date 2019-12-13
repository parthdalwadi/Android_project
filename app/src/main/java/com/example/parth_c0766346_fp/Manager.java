package com.example.parth_c0766346_fp;

import androidx.annotation.NonNull;

public class Manager extends Employee {

    private final int GAIN_FACTOR_CLIENT = 500;
    private int nbClients;

    public Manager(String name, int id, int birthYear, double monthlySalary, double rate, Vehicle empVehicle, int nbClients) {
        super(name, id, birthYear, monthlySalary, rate, empVehicle);
        this.nbClients = nbClients;
    }

    @Override
    public double annualIncome() {
        return super.annualIncome() + (nbClients*GAIN_FACTOR_CLIENT);
    }

    @Override
    public String getDesignation() {
        return "Manager";
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + String.format("He/She has brought %d new clients.", nbClients );
    }
}

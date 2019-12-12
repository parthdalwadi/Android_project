package com.example.parth_c0766346_fp;

public class Manager extends Employee {

    private final int GAIN_FACTOR_CLIENT = 500;
    private int nbClients;

    public Manager(String name, int birthYear, double monthlySalary, double rate, Vehicle empVehicle, int nbClients) {
        super(name, birthYear, monthlySalary, rate, empVehicle);
        this.nbClients = nbClients;
    }

    @Override
    public double annualIncome() {
        return super.annualIncome() + (nbClients*GAIN_FACTOR_CLIENT);
    }
}

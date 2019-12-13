package com.example.parth_c0766346_fp;

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


}

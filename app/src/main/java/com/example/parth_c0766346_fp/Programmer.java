package com.example.parth_c0766346_fp;

public class Programmer extends Employee {

    private final int GAIN_FACTOR_PROJECTS = 200;
    private int nbProjects;

    public Programmer(String name, int birthYear, double monthlySalary, double rate, Vehicle empVehicle, int nbProjects) {
        super(name, birthYear, monthlySalary, rate, empVehicle);
        this.nbProjects = nbProjects;
    }

    @Override
    public double annualIncome() {
        return super.annualIncome() + (nbProjects*GAIN_FACTOR_PROJECTS);
    }
}

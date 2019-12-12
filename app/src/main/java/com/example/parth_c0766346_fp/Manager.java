package com.example.parth_c0766346_fp;

public class Manager extends Employee {

    private int nbClients;

    public Manager(String name, int birthYear, double monthlySalary, double rate, Vehicle empVehicle, int nbClients) {
        super(name, birthYear, monthlySalary, rate, empVehicle);
        this.nbClients = nbClients;
    }
}

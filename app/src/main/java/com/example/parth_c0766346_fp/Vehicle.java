package com.example.parth_c0766346_fp;

import androidx.annotation.NonNull;

public class Vehicle {

    private String make, plate, color;

    public Vehicle(String make, String plate, String color) {
        this.make = make;
        this.plate = plate;
        this.color = color;
    }

    @NonNull
    @Override
    public String toString() {

        return "Employee has a" + getType() +
                "\n\t - make:" + make + "\n\t - plate:" + plate + "\n\t - color:" + color;

    }

    public String getType(){
        return "Vehicle";
    }
}

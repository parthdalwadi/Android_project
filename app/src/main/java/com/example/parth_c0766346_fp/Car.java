package com.example.parth_c0766346_fp;

import androidx.annotation.NonNull;

public class Car extends Vehicle {

    String type;

    public Car(String make, String plate, String color, String type) {
        super(make, plate, color);
        this.type = type;
    }

    @Override
    public String getType() {
        return  "car";
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + "\n\t - type: " + type;
    }
}

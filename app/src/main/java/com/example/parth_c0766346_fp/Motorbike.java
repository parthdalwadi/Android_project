package com.example.parth_c0766346_fp;

import androidx.annotation.NonNull;

public class Motorbike extends Vehicle {

    boolean sidecar;

    public Motorbike(String make, String plate, String color, boolean sidecar) {
        super(make, plate, color);
        this.sidecar = sidecar;
    }

    @Override
    public String getType() {
        return "motorcycle";
    }

    @NonNull
    @Override
    public String toString() {
        String side = sidecar ? "with" : "without";
        return super.toString() + side + "sidecar" ;
    }
}

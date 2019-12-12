package com.example.parth_c0766346_fp;

public class Motorbike extends Vehicle {

    boolean sidecar;

    public Motorbike(String make, String plate, String color, boolean sidecar) {
        super(make, plate, color);
        this.sidecar = sidecar;
    }
}

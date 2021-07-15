package com.shutl.application.model;

import java.security.InvalidKeyException;
import java.util.ArrayList;

public enum VehicleMarkup {
    bicycle(0.10),
    motorbike(0.15),
    parcel_car(0.20),
    small_val(0.30),
    large_van(0.40);

    private double value;

    VehicleMarkup(double value){
        this.value = value;
    }

    public static ArrayList<String> getVehicleList(){
        ArrayList<String> keys = new ArrayList<String>();
        for (VehicleMarkup vehicle : VehicleMarkup.values())
        {
            String name = vehicle.name();
            keys.add(name);
        }
        return keys;
    }

    public double getMarkupByVehicle() throws NullPointerException {
        try {
            return value;
        } catch (NullPointerException e){
            throw new NullPointerException();
        }
    }
}

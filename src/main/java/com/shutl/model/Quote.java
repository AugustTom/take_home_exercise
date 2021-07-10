package com.shutl.model;

import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.Map;

public class Quote {
    String pickupPostcode;
    String deliveryPostcode;
    Long price;
    String vehicle;

    public double getMarkupByVehicle(String vehicle) throws InvalidKeyException {
        try {
            return vehicle_markup.get(vehicle);
        } catch (NullPointerException e){
            throw new InvalidKeyException("Invalid vehicle input", e.getCause());
        }
    }

    private static final Map<String, Double> vehicle_markup = new HashMap<>() {{
        put("bicycle",0.10);
        put("motorbike",0.15);
        put("parcel_car",0.20);
        put("small_val",0.30);
        put("large_van",0.40);
    }};

    public Quote() {}

    public Quote(String pickupPostcode, String deliveryPostcode) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
    }

    public Quote(String pickupPostcode, String deliveryPostcode, Long price) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.price = price;
    }

    public Quote(String pickupPostcode, String deliveryPostcode, String vehicle) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.vehicle = vehicle;
    }

    public Quote(String pickupPostcode, String deliveryPostcode, String vehicle, Long price) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.vehicle = vehicle;
        this.price = price;
    }

    public String getPickupPostcode() {
        return pickupPostcode;
    }

    public void setPickupPostcode(String pickupPostcode) {
        this.pickupPostcode = pickupPostcode;
    }

    public String getDeliveryPostcode() {
        return deliveryPostcode;
    }

    public void setDeliveryPostcode(String deliveryPostcode) {
        this.deliveryPostcode = deliveryPostcode;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}

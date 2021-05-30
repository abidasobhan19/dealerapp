package com.forbitbd.Dealer.models;


import java.io.Serializable;

public class Device implements Serializable {

    private Dealer dealer;
    private String dealer_id;
    private String device_id;
    private String vehicle_reg;
    private String vehicle_type;
    private String device_sim;
    private String customer_name;
    private String customer_phone;
    private String customer_email;





    public Device() {
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public String getDealer_id() {
        return dealer_id;
    }

    public void setDealer_id(String dealer_id) {
        this.dealer_id = dealer_id;
    }
    //    public String getDealer() {
//        return dealer;
//    }
//
//    public void setDealer(String dealer) {
//        this.dealer = dealer;
//    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getVehicle_reg() {
        return vehicle_reg;
    }

    public void setVehicle_reg(String vehicle_reg) {
        this.vehicle_reg = vehicle_reg;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getDevice_sim() {
        return device_sim;
    }

    public void setDevice_sim(String device_sim) {
        this.device_sim = device_sim;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }


}


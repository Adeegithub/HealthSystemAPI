/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author ishara
 */
public class Billing {
    private int billingId;
    private int patientId;
    private double amountDue;
    
    //Default Constructor ->Neccessary to deserialize JSON into Java objects
    public Billing(){
        
    }
    
    //Constructor

    public Billing(int billingId, int patientId, double amountDue) {
        this.billingId = billingId;
        this.patientId = patientId;
        this.amountDue = amountDue;
    }
    
    //Getters and Setters

    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author ishara
 */
public class Doctor extends Person {
    private int doctorId;
    private String specialization;
    
    //Default Constructor ->Neccessary to deserialize JSON into Java objects
    public Doctor(){
        
    }
    
    //Constructor

    public Doctor(int doctorId, String specialization, int personId, String personName, String personPhone, String email, String address) {
        super(personId, personName, personPhone, email, address);
        this.doctorId = doctorId;
        this.specialization = specialization;
    }
    
    //Getters and Setters

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author ishara
 */
public class Patient extends Person {
    private int patientId;
    private String medicalHistory;
    private String currentHealthStatus;
    
    //Default Constructor ->Neccessary to deserialize JSON into Java objects
    public Patient(){
        
    }
    
    //Constructor

    public Patient(int patientId, String medicalHistory, String currentHealthStatus, int personId, String personName, String personPhone, String email, String address) {
        super(personId, personName, personPhone, email, address);
        this.patientId = patientId;
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
    }
    
    //Getters and Setters

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }
}

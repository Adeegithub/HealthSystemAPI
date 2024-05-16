/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author ishara
 */
public class MedicalRecord {
    private int medicalRecordId;
    private int patientId;
    private String details;
    
    //Default Constructor ->Neccessary to deserialize JSON into Java objects
    public MedicalRecord(){
        
    }
    
    //Constructor

    public MedicalRecord(int medicalRecordId, int patientId, String details) {
        this.medicalRecordId = medicalRecordId;
        this.patientId = patientId;
        this.details = details;
    }
    
    //Getters and Setters

    public int getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(int medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

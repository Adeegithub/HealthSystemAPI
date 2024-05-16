/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Patient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ishara
 */
public class PatientDAO {
    private static List<Patient> patients = new ArrayList<>();
    
    //Adding patient to the patients list
    static {
        patients.add(new Patient(3000,"Asthma","Normal",1006,"Rashid Khan","0775860147","rashid@gmail.com","Afghanistan"));
        patients.add(new Patient(3001,"Common Cold","Normal",1007,"Noor Ahmed","0772560147","noor@gmail.com","Afghanistan"));
    }
    
    //Retieving All Patients
    public List <Patient> getAllPatient(){
        return patients;
    }
    
    //Get patient by ID
    public Patient getPatientById(int id){
        for(Patient patient : patients){
            if(patient.getPatientId() == id){
                return patient;
            }
        }
        return null;
    }
    
    //Create Patient
    public void addPatient(Patient patient){
        int newPatientId = getNextPatientId();
        patient.setPatientId(newPatientId);
        patients.add(patient);
    }
    
    //Update Patient
    public void updatePatient(Patient updatedpatient){
        for(int i=0; i<patients.size(); i++){
            Patient patient = patients.get(i);
            if(patient.getPatientId() == updatedpatient.getPatientId()){
                patients.set(i, updatedpatient);
                System.out.println("Updated Patient" + updatedpatient);
                return;
            }
        }
    }
    
    //Delete Patient
    public boolean deletePatient(int id){
        boolean patienExists = patients.removeIf(patient -> patient.getPatientId() == id);
        return patienExists;
    }
    
    public int getNextPatientId(){
        //Initialize maxUserId with a value lower than any possible userId
        int maxUserId = Integer.MIN_VALUE;
        
        //Iterate through the list to find the maximum userId
        for(Patient patient : patients){
            int userId = patient.getPatientId();
            if (userId >  maxUserId){
                maxUserId = userId;
            }
        }
        //Increment the maximum userId to get the next available userId
        return maxUserId + 1;
    }
}

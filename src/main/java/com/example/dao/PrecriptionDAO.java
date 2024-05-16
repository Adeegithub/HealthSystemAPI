/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Prescription;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ishara
 */
public class PrecriptionDAO {
    private static List<Prescription> prescriptions = new ArrayList<>();
    
    //Adding Prescriptions to the prescriptions list
    static {
        prescriptions.add(new Prescription(7000,3000,2000,"Panadol"));
        prescriptions.add(new Prescription(7001,3001,2001,"Ventolin"));
    }
    
    //Retieving All prescriptions
    public List <Prescription> getAllPrescriptions(){
        return prescriptions;
    }
    
    //Get Medical Record by ID
    public Prescription getPrescriptionById(int id){
        for(Prescription prescription : prescriptions){
            if(prescription.getPrescriptionId() == id){
                return prescription;
            }
        }
        return null;
    }
    
    //Create Prescription
    public void addPrescription(Prescription prescription){
        int newPrescriptionId = getNextPrescriptionId();
        prescription.setPrescriptionId(newPrescriptionId);
        prescriptions.add(prescription);
    }
    
    //Update Prescription
    public void updatePrescription(Prescription updatedPrescreption){
        for(int i=0; i<prescriptions.size(); i++){
            Prescription prescription = prescriptions.get(i);
            if(prescription.getPrescriptionId() == updatedPrescreption.getPrescriptionId()){
                prescriptions.set(i, updatedPrescreption);
                System.out.println("Updated Prescription" + updatedPrescreption);
                return;
            }
        }
    }
    
    //Delete Precription
    public boolean deletePrecription(int id){
        boolean prescriptionExists = prescriptions.removeIf(pr -> pr.getPrescriptionId() == id);
        return prescriptionExists;
    }
    
    public int getNextPrescriptionId(){
        //Initialize maxUserId with a value lower than any possible userId
        int maxUserId = Integer.MIN_VALUE;
        
        //Iterate through the list to find the maximum userId
        for(Prescription prescription : prescriptions){
            int userId = prescription.getPrescriptionId();
            if (userId >  maxUserId){
                maxUserId = userId;
            }
        }
        //Increment the maximum userId to get the next available userId
        return maxUserId + 1;
    }
}

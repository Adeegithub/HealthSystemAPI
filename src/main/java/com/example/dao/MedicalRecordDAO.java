/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.MedicalRecord;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ishara
 */
public class MedicalRecordDAO {
    private static List<MedicalRecord> medicalRecords = new ArrayList<>();
    
    //Adding Medical Rcords to the medicalRecords list
    static {
        medicalRecords.add(new MedicalRecord(6000,3000,"Medical Record One"));
        medicalRecords.add(new MedicalRecord(6001,3001,"Medical Record Two"));
    }
    
    //Retieving All Medical Rcords
    public List <MedicalRecord> getAllMedicalRecords(){
        return medicalRecords;
    }
    
    //Get Medical Record by ID
    public MedicalRecord getMedicalRecordById(int id){
        for(MedicalRecord medicalRecord : medicalRecords){
            if(medicalRecord.getMedicalRecordId() == id){
                return medicalRecord;
            }
        }
        return null;
    }
    
    //Create Medical Record
    public void addMedicalRecord(MedicalRecord medicalRecord){
        int newMedicalRecordId = getNextMedicalRecordId();
        medicalRecord.setMedicalRecordId(newMedicalRecordId);
        medicalRecords.add(medicalRecord);
    }
    
    //Update MedicalRecord
    public void updateMedicalRecord(MedicalRecord updatedmedicalRecord){
        for(int i=0; i<medicalRecords.size(); i++){
            MedicalRecord medicalRecord = medicalRecords.get(i);
            if(medicalRecord.getMedicalRecordId() == updatedmedicalRecord.getMedicalRecordId()){
                medicalRecords.set(i, updatedmedicalRecord);
                System.out.println("Updated Medical Record" + updatedmedicalRecord);
                return;
            }
        }
    }
    
    //Delete Appointment
    public boolean deleteMedicalRecord(int id){
        boolean medicalRecordsExists = medicalRecords.removeIf(mr -> mr.getMedicalRecordId() == id);
        return medicalRecordsExists;
    }
    
    public int getNextMedicalRecordId(){
        //Initialize maxUserId with a value lower than any possible userId
        int maxUserId = Integer.MIN_VALUE;
        
        //Iterate through the list to find the maximum userId
        for(MedicalRecord medicalRecord : medicalRecords){
            int userId = medicalRecord.getMedicalRecordId();
            if (userId >  maxUserId){
                maxUserId = userId;
            }
        }
        //Increment the maximum userId to get the next available userId
        return maxUserId + 1;
    }
}

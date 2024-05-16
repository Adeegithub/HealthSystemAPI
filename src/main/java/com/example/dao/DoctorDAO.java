/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ishara
 */
public class DoctorDAO {
    private static List<Doctor> doctors = new ArrayList<>();
    
    //Adding doctor to the doctors list
    static {
        doctors.add(new Doctor(2000,"ENT",1003,"Ravindra Jadeja","0772580147","Ravi@gmail.com","India"));
        doctors.add(new Doctor(2001,"Physician",1004,"Ravi Ashvin","0775856321","ash@gmail.com","India"));
    }
    
    //Retieving All Doctors
    public List <Doctor> getAllDoctors(){
        return doctors;
    }
    
    //Get Doctor by ID
    public Doctor getDoctorById(int id){
        for(Doctor doctor : doctors){
            if(doctor.getDoctorId() == id){
                return doctor;
            }
        }
        return null;
    }
    
    //Create Doctor
    public void addDoctor(Doctor doctor){
        int newDoctorId = getNextDoctorId();
        doctor.setDoctorId(newDoctorId);
        doctors.add(doctor);
    }
    
    //Update Doctor
    public void updateDoctor(Doctor updatedDoctor){
        for(int i=0; i<doctors.size(); i++){
            Doctor doctor = doctors.get(i);
            if(doctor.getDoctorId() == updatedDoctor.getDoctorId()){
                doctors.set(i, updatedDoctor);
                System.out.println("Updated Student" + updatedDoctor);
                return;
            }
        }
    }
    
    //Delete Doctor
    public boolean deleteDoctor(int id){
        boolean doctorExists = doctors.removeIf(doctor -> doctor.getDoctorId() == id);
        return doctorExists;
    }
    
    public int getNextDoctorId(){
        //Initialize maxUserId with a value lower than any possible userId
        int maxUserId = Integer.MIN_VALUE;
        
        //Iterate through the list to find the maximum userId
        for(Doctor doctor : doctors){
            int userId = doctor.getDoctorId();
            if (userId >  maxUserId){
                maxUserId = userId;
            }
        }
        //Increment the maximum userId to get the next available userId
        return maxUserId + 1;
    }
}

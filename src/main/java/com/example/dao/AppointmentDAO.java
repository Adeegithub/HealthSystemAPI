/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Appointment;
import com.example.model.Doctor;
import com.example.model.Patient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ishara
 */
public class AppointmentDAO {
    private static List<Appointment> appointments = new ArrayList<>();
    
    //Adding apppointment to the appointments list
    static {
        appointments.add(new Appointment(4000,3000,2000,"12 MAR 2024","08.00 AM"));
        appointments.add(new Appointment(4001,3001,2001,"13 MAR 2024","09.00 AM"));
    }
    
    //Retieving All Appointments
    public List <Appointment> getAllAppointment(){
        return appointments;
    }
    
    //Get appointed by ID
    public Appointment getApppointmentById(int id){
        for(Appointment appointment : appointments){
            if(appointment.getAppointmentId() == id){
                return appointment;
            }
        }
        return null;
    }
    
    //Create Appointment
    public void addAppointment(Appointment appointment){
        int newAppointmentId = getNextAppointmentId();
        appointment.setPatientId(newAppointmentId);
        appointments.add(appointment);
    }
    
    //Update Appointment
    public void updateAppointment(Appointment updatedAppointment){
        for(int i=0; i<appointments.size(); i++){
            Appointment appointment = appointments.get(i);
            if(appointment.getAppointmentId() == updatedAppointment.getAppointmentId()){
                appointments.set(i, updatedAppointment);
                System.out.println("Updated Appointment" + updatedAppointment);
                return;
            }
        }
    }
    
    //Delete Appointment
    public boolean deleteAppointment(int id){
        //Check if the appointment with the given id exists
        boolean appointmentExists = appointments.removeIf(appointment -> appointment.getAppointmentId() == id);
        
        //Return true if the appointment is found and removed, else return false
        return appointmentExists;
    }
    
    public int getNextAppointmentId(){
        //Initialize maxUserId with a value lower than any possible userId
        int maxUserId = Integer.MIN_VALUE;
        
        //Iterate through the list to find the maximum userId
        for(Appointment appointment : appointments){
            int userId = appointment.getAppointmentId();
            if (userId >  maxUserId){
                maxUserId = userId;
            }
        }
        //Increment the maximum userId to get the next available userId
        return maxUserId + 1;
    }
}

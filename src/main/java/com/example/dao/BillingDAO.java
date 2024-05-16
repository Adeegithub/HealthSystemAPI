/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Billing;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ishara
 */
public class BillingDAO {
    private static List<Billing> bills = new ArrayList<>();
    
    //Adding billing to the bills list
    static {
        bills.add(new Billing(5000,3000,2400.00));
        bills.add(new Billing(5001,3001,2800.00));
    }
    
    //Retieving All Bills
    public List <Billing> getAllBilling(){
        return bills;
    }
    
    //Get bill by ID
    public Billing getBillingById(int id){
        for(Billing billings : bills){
            if(billings.getBillingId() == id){
                return billings;
            }
        }
        return null;
    }
    
    //Create Bill
    public void addBilling(Billing billing){
        int newBillingId = getNextBillingId();
        billing.setBillingId(newBillingId);
        bills.add(billing);
    }
    
    //Update Bill
    public void updateBilling(Billing updatedBilling){
        for(int i=0; i<bills.size(); i++){
            Billing billing = bills.get(i);
            if(billing.getBillingId() == updatedBilling.getBillingId()){
                bills.set(i, updatedBilling);
                System.out.println("Updated Bill" + updatedBilling);
                return;
            }
        }
    }
    
    //Delete Bill
    public boolean deleteBill(int id){
        boolean billExists = bills.removeIf(billing -> billing.getBillingId() == id);
        return billExists;
    }
    
    public int getNextBillingId(){
        //Initialize maxUserId with a value lower than any possible userId
        int maxUserId = Integer.MIN_VALUE;
        
        //Iterate through the list to find the maximum userId
        for(Billing billing : bills){
            int userId = billing.getBillingId();
            if (userId >  maxUserId){
                maxUserId = userId;
            }
        }
        //Increment the maximum userId to get the next available userId
        return maxUserId + 1;
    } 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author ishara
 */
public class Person {

    private int personId;
    private String personName;
    private String personPhone;
    private String email;
    private String address;

    //Default Constructor -> Neccessary to deserialize JSON into Java objects
    public Person() {
    }

    //Constructor
    public Person(int personId, String personName, String personPhone, String email, String address) {
        this.personId = personId;
        this.personName = personName;
        this.personPhone = personPhone;
        this.email = email;
        this.address = address;
    }

    //Getters and Setters
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

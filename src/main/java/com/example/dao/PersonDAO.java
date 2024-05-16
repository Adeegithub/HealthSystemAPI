/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ishara
 */
public class PersonDAO {
    private static List<Person> persons = new ArrayList<>();
    
    //Adding person to the persons list
    static {
        persons.add(new Person(1000,"Tom Latham","0772520147","tom@gmail.com","New Zealand"));
        persons.add(new Person(1001,"Jimmy Neeesham","0772520148","jimmy@gmail.com","New Zealand"));
    }
    
    //Retieving All Students
    public List <Person> getAllPerson(){
        return persons;
    }
    
    //Get Person by ID
    public Person getPersonById(int personId){
        for(Person person : persons){
            if(person.getPersonId() == personId){
                return person;
            }
        }
        return null;
    }
    
    //Create Person
    public void addPerson(Person person){
        int newPersonId = getNextPersonId();
        person.setPersonId(newPersonId);
        persons.add(person);
    }
    
    //Update Person
    public void updatePerson(Person updatedPerson){
        for(int i=0; i<persons.size(); i++){
            Person person = persons.get(i);
            if(person.getPersonId() == updatedPerson.getPersonId()){
                persons.set(i, updatedPerson);
                System.out.println("Updated Person" + updatedPerson);
                return;
            }
        }
    }
    
    //Delete Student
    public boolean deletePerson(int id){
        //Check if the person with the given id exists
        boolean personExists = persons.removeIf(person -> person.getPersonId() == id);
        
        //Return true if the person is found and removed, else return false
        return personExists;
        
    }
    
    public int getNextPersonId(){
        //Initialize maxUserId with a value lower than any possible userId
        int maxUserId = Integer.MIN_VALUE;
        
        //Iterate through the list to find the maximum userId
        for(Person person : persons){
            int userId = person.getPersonId();
            if (userId >  maxUserId){
                maxUserId = userId;
            }
        }
        //Increment the maximum userId to get the next available userId
        return maxUserId + 1;
    }
}

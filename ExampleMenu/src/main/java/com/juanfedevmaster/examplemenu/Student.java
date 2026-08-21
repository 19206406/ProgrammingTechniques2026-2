/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanfedevmaster.examplemenu;

import java.util.ArrayList;

/**
 *
 * @author juanfe
 */
public class Student {
    private String name;
    private String lastName;
    private String career;
    private ArrayList<Subject> subjects;

    public Student(String name, String lastName, String career, ArrayList<Subject> subjects) {
        this.name = name;
        this.lastName = lastName;
        this.career = career;
        this.subjects = subjects;
    }
    
    public Student(){
    
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCareer() {
        return career;
    }
    
    
}

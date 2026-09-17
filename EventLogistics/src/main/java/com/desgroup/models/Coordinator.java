/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desgroup.models;

import java.util.ArrayList;

/**
 *
 * @author urreg
 */
public class Coordinator extends Staff {
    private String company; 
    private ArrayList<Logistic> logistics; 

    public Coordinator(String company, ArrayList<Logistic> logistics, int id, String name, String email, int phone, String position, String password, double salary) {
        super(id, name, email, phone, position, password, salary);
        this.company = company;
        this.logistics = logistics;
    }

    public Coordinator() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<Logistic> getLogistics() {
        return logistics;
    }

    public void setLogistics(ArrayList<Logistic> logistics) {
        this.logistics = logistics;
    }
}

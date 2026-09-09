/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanfedevmaster.examplepoo.entities;

/**
 *
 * @author juanfe
 */
public class Employee extends Person{
    private int salary;
    private String tip;
    private String position;
    private String jobModality;

    public Employee() {
       
    }

    public Employee(int salary, String tip, String position, String jobModality, String name, String lastName, String cellPhone, String email) {
        super(name, lastName, cellPhone, email);
        this.salary = salary;
        this.tip = tip;
        this.position = position;
        this.jobModality = jobModality;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJobModality() {
        return jobModality;
    }

    public void setJobModality(String jobModality) {
        this.jobModality = jobModality;
    }

    @Override
    public void setTransportMethodPeerPerson(String transportMethod) {
        this.setTransportMethod(transportMethod);
    }
}

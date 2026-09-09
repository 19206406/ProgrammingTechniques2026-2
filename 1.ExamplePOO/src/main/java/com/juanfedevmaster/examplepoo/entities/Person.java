/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juanfedevmaster.examplepoo.entities;

/**
 *
 * @author juanfe
 */
public abstract class Person {

    private String name;
    private String lastName;
    private String cellPhone;
    private String email;
    
    private String transportMethod;
    
    public Person() {
    }

    public Person(String name, String lastName, String cellPhone, String email) {
        this.name = name;
        this.lastName = lastName;
        this.cellPhone = cellPhone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTransportMethod() {
        return transportMethod;
    }

    public void setTransportMethod(String transportMethod) {
        this.transportMethod = transportMethod;
    }
    
    public abstract void setTransportMethodPeerPerson(String transportMethod);
}

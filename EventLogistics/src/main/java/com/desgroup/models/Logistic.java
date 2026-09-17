/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desgroup.models;

/**
 *
 * @author urreg
 */
public class Logistic extends Staff {
    private String zone; 
    private int workingHours; 
    private String Role; 
    private int Score; 

    public Logistic(String zone, int workingHours, String Role, int Score, int id, String name, String email, int phone, String position, String password, double salary) {
        super(id, name, email, phone, position, password, salary);
        this.zone = zone;
        this.workingHours = workingHours;
        this.Role = Role;
        this.Score = Score;
    }

    public Logistic(int id, String name, String email, int phone, String position, String password, double salary) {
        super(id, name, email, phone, position, password, salary);
    }

    public Logistic() {
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }
}

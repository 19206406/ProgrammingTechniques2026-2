package com.juanfedevmaster.models;

import com.juanfedevmaster.interfaces.IFigura;

public class Cuadrado implements IFigura {
    private double base;
    private double lado;

    public Cuadrado(double base, double lado){
        this.base = base;
        this.lado = lado;
    }
   
    public void setBase(double base){
        this.base = base;
    }

    public double getBase(){
        return this.base;
    }

    public void setLado(double lado){
        this.lado = lado;
    }

    public double getLado(){
        return this.lado;
    }

    @Override
    public double calcularArea() {
       return this.base*this.lado;
    }
}

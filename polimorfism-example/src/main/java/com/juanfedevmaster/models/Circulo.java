package com.juanfedevmaster.models;

import com.juanfedevmaster.interfaces.IFigura;

public class Circulo  implements IFigura{

    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    public void setRadio(double radio){
        this.radio = radio;
    }

    public double getRadio(){
        return this.radio;
    }

    @Override
    public double calcularArea() {
        return 2*Math.PI*this.radio;
    }



}

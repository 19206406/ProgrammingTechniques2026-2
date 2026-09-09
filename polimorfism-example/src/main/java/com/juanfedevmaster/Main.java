package com.juanfedevmaster;

import com.juanfedevmaster.interfaces.IFigura;
import com.juanfedevmaster.models.Circulo;
import com.juanfedevmaster.models.Cuadrado;

public class Main {
    public static void main(String[] args) {
        IFigura c = new Cuadrado(10,5);
       
        System.out.println(c.calcularArea());

        c = new Circulo(34.5);
       
        System.out.println(c.calcularArea());
    }
}
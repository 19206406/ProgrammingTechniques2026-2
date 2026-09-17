package com.sebastianurrego;

import com.sebastianurrego.interfaces.ICalculadoraBono;
import com.sebastianurrego.modelos.CalculadoraBono;

public class Main {
    public static void main(String[] args) {
        // Ejemplo de Liskov. Capacidad de reemplazar una clase instanciada en por su
        // abstración
        ICalculadoraBono calculadoraBono = new CalculadoraBono("Jefe");
    }
}
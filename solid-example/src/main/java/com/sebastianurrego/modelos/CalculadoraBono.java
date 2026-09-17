package com.sebastianurrego.modelos;

import com.sebastianurrego.interfaces.ICalculadoraBono;

// Open Close, explicación con una calculadora de bonos laborales 
// Como ejemplo de el principio Open Close 
public class CalculadoraBono implements ICalculadoraBono {

    private final String tipoEmpleado;

    public CalculadoraBono(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public double calcularBono(double salario) {
        if (this.tipoEmpleado.equals("Jefe")) {
            return salario * 0.10;
        }
        if (this.tipoEmpleado.equals("QA")) {
            return salario * 0.07;
        } else {
            return salario * 0.05;
        }
    }

    public double extraBonus(int antiguedad, double salario) {
        if (antiguedad <= 3) {
            return salario;
        }

        if (antiguedad > 3 && antiguedad < 12) {
            return salario * 0.02;
        }
        if (antiguedad >= 12 && antiguedad < 24) {
            return salario * 0.05;
        } else {
            return salario * 0.10;
        }
    }

}

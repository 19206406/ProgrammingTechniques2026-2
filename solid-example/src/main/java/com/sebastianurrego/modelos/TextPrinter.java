package com.sebastianurrego.modelos;

import java.util.Arrays;

// Ejemplo de Single Responsability 
// Ejemplo de Single Responsability. Solamente esta encargado de realizar una unica tarea, o tareas 
// relacionadas con la funcionalidad de impresión 

public class TextPrinter {
    private String textoImpresion;

    public TextPrinter() {

    }

    public void setTextoImpresion(String textoImpresion) {
        this.textoImpresion = textoImpresion;
    }

    public String getTextoImpresion() {
        return this.textoImpresion;
    }

    public void mostrarTextoPorLetra() {
        System.out.println(Arrays.toString(this.textoImpresion.toCharArray()));
    }

    public void mostrarTextCadaNumeroPar() {
        for (int i = 0; i < this.textoImpresion.length(); i++) {
            if (i % 2 == 0) {
                System.out.println(this.textoImpresion.toCharArray()[i]);
            }
        }
    }

    public void imprimirTexto(String texto) {
        System.out.println(texto);
    }
}

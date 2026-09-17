package com.sebastianurrego.modelos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

// Ejemplo Interface Segregation (Segregation de interfaces)
public class ImpresoraMultiFuncional {

    public void ImprimirTexto(String texto) {
        System.out.println(texto);
    }

    public void ScannearTexto(String rutaArchivo) {
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

        while (br.readLine() != null) {
            System.out.println(br.readLine());
        }
    }
}

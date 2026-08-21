/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.juanfedevmaster.examplemenu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juanfe
 */
public class ExampleMenu {

    public static void main(String[] args) {
        // 1. El estudiante debe tener Nombre, Apellido, Carrera
        // 2. Asignatura debe tener Nombre y Código

        // Regla de Negocio: 
        // 1. Un estudiante Puede tener muchas Asignaturas.
        // 2. Un Asignatura Puede tener muchos Estudiantes.
        // Instancia nuevo objeto
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Subject> subjects = new ArrayList<>();
        int option = 0;

        subjects.add(new Subject("Tec. de Programacion", "Sb1"));
        subjects.add(new Subject("Logica 2", "Sb2"));
        subjects.add(new Subject("Bases de Datos", "Sb3"));

        do {
            System.out.println("+++++++++++++++++++++++");
            System.out.println("University of Antioquia");
            System.out.println("+++++++++++++++++++++++");
            System.out.println("1. Create Student");
            System.out.println("2. Print all Students");
            System.out.println("3. Exit");

            Scanner scan = new Scanner(System.in);

            int optionUser = scan.nextInt();
            scan.nextLine();

            switch (optionUser) {
                case 1:
                    option = 1;
                    Student student = new Student();

                    System.out.println("Set the name of the new Student:");
                    student.setName(scan.nextLine());

                    System.out.println("Set the last name of the new Student:");
                    student.setLastName(scan.nextLine());

                    System.out.println("Set the career of the new Student:");
                    student.setCareer(scan.nextLine());

                    students.add(student);

                    break;
                case 2:
                    System.out.println("The total students are: " + students.size());

                    for (Student s : students) {
                        System.out.println("+++++++++++++");
                        System.out.println("The full name of the student is: " + s.getName() + " " + s.getLastName());
                        System.out.println("Career: "+ s.getCareer());
                    }   
                    break;
                default:
                    option = -1;
                    break;
            }

        } while (option > 0);
    }
}

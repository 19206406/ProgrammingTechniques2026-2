/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.juanfedevmaster.examplemenu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sebastian Urrego Graciano
 * @author Juan David Ortiz Diaz
 * @author JUAN ESTEBAN BALLESTEROS SANCHEZ
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
            System.out.println("3. Create subjects");
            System.out.println("4. Print all Subjects");
            System.out.println("5. Assign subjects to students");
            System.out.println("6. View a student's courses");
            System.out.println("7. Exit");

            Scanner scan = new Scanner(System.in);
            Scanner continueKey = new Scanner (System.in);
            
            int optionUser = scan.nextInt();
            scan.nextLine();

            switch (optionUser) {
                case 1:
                    option = 1;
                    Student student = new Student();

                    System.out.println("Set the name of the new Student:");
                    student.setName(scan.nextLine().trim());

                    System.out.println("Set the last name of the new Student:");
                    student.setLastName(scan.nextLine().trim());

                    System.out.println("Set the career of the new Student:");
                    student.setCareer(scan.nextLine().trim());

                    // inicializar subjects para evitar nulos.
                    student.setSubjects(new ArrayList<>());

                    students.add(student);
                    
                    System.out.println("Press enter to continue");
                    continueKey.nextLine();
                
                    break;
                case 2:
                    option = 2;
                    System.out.println("The total students are: " + students.size());

                    for (Student s : students) {
                        System.out.println("+++++++++++++");
                        System.out.println("The full name of the student is: " + s.getName() + " " + s.getLastName());
                        System.out.println("Career: " + s.getCareer());
                    }
                    
                    System.out.println("Press enter to continue");
                    continueKey.nextLine();
                
                    break;
                case 3:
                    option = 3;
                    Subject subject = new Subject();

                    System.out.println("Set the name of the new Subject:");
                    subject.setName(scan.nextLine().trim());

                    System.out.println("Set the code of the new Subject:");
                    subject.setCode(scan.nextLine().trim());

                    subjects.add(subject);
                    
                    System.out.println("Press enter to continue");
                    continueKey.nextLine();
                
                    break;
                case 4:
                    option = 4;
                    System.out.println("The total subjects are: " + subjects.size());
                    printSubjects(subjects);
                    
                    System.out.println("Press enter to continue");
                    continueKey.nextLine();    
                    
                    break;
                case 5:
                    option = 5;
                    System.out.println("Enter the student's name:");
                    String name = scan.nextLine();
                    Student selectedStudent = null;

                    ArrayList<Subject> studentSubjects = new ArrayList<>();

                    String code;

                    for (Student student1 : students) {
                        if (student1.getName().contains(name)) {

                            selectedStudent = student1;

                            studentSubjects = student1.getSubjects();

                            // Validación inicial cada vez que se ingresa a la opción
                            if (studentSubjects.size() >= 3) {
                                System.out.println("A student may enroll in only three subjects");
                                break;
                            }

                            printSubjects(subjects); // mostrar materias

                            System.out.println("Enter the subjects codes one by one.");

                            do {

                                System.out.println("1. Enter code");
                                System.out.println("2. Exit");
                                optionUser = scan.nextInt();
                                scan.nextLine();

                                switch (optionUser) {
                                    case 1:
                                        // validación cuando se ingresa cada vez un elemento
                                        if (studentSubjects.size() >= 3) {
                                            System.out.println("A student may enroll in only three subjects");
                                            break;
                                        }

                                        System.out.println("Code subject:");
                                        code = scan.nextLine();
                                        Subject newSubject = null;

                                        // validar si el code del subject existe antes de ingresar al array
                                        for (Subject subject1 : subjects)  {
                                            if (subject1.getCode().equals(code)) {
                                                newSubject = subject1;
                                            }
                                        }

                                        if (newSubject == null) {
                                            System.out.println("There is no subject with that code.");
                                        }

                                        if (!studentSubjects.contains(newSubject)) {
                                            studentSubjects.add(newSubject);
                                        } else {
                                            System.out.println("The student has already taken this subject.");
                                        }

                                        break;

                                    default:
                                        student1.setSubjects(studentSubjects); // asignamos las materias al estudiante
                                        optionUser = -1;
                                        break;
                                }

                            } while(optionUser > 0);


                        }
                    }

                    if (selectedStudent == null) {
                        System.out.println("There is no student with that name");
                    }

                    break;

                case 6:
                    option  = 6;
                    System.out.println("Enter the student's name:");
                    String searchStudent = scan.nextLine();
                    
                    for (Student s : students) {
                        if (s.getName().contains(searchStudent)) {
                            System.out.println("+++++++++++++");
                            System.out.println("The full name of the student is: " + s.getName() + " " + s.getLastName());
                            System.out.println("Career: " + s.getCareer());

                            System.out.println("++++++++++++++");
                            System.out.println("total number of registered subjects : " + s.getSubjects().size());
                            if (!s.getSubjects().isEmpty()) {
                                System.out.println("student's registered subjects:");
                                printSubjects(s.getSubjects());
                            }
                        } else {
                            System.out.println("Student not found");
                        }
                    }

                    break;


                default:
                    option = -1;
                    scan.close();
                    break;
            }

        } while (option > 0);

    }

    public static void printSubjects(ArrayList<Subject> subjects) {
        for (Subject s : subjects) {
            System.out.println("+++++++++++++");
            System.out.println("The name of the subject is: " + s.getName());
            System.out.println("Code: " + s.getCode());
        }
    }
}

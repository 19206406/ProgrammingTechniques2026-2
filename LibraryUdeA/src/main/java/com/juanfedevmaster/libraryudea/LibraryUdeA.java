/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.juanfedevmaster.libraryudea;

import java.util.ArrayList;
import java.util.Scanner;
import library.models.Book;
import library.models.Catalog;
import library.models.ResultBook;

/**
 * SEBASTIAN URREGO GRACIANO
 * JUAN DAVID ORTIZ DIAZ
 *
 * @author juanfe
 */
public class LibraryUdeA {

    public static void main(String[] args) {

        Catalog catalog = new Catalog();

        int option = 0;
        Scanner scan = new Scanner(System.in);

        catalog.registerBook("abc123", "Dance of dragons", "George R.R Martin", 200);
        catalog.registerBook("bcd234", "Blood and fire", "George R.R Martin", 369);


        do {
            System.out.println("1. Register book");
            System.out.println("2. Buy a book");
            System.out.println("3. Show all books of the catalog.");
            System.out.println("4. Search for a book by ISBN");
            System.out.println("5. Exit");

            System.out.println("Enter the option:");
            option = Integer.parseInt(scan.nextLine().trim());

            switch (option) {
                case 1: // Registrar Libro
                    System.out.println("Enter the isbn code:");
                    String isbn = scan.nextLine().trim();
                    System.out.println("Enter the title:");
                    String title = scan.nextLine().trim();
                    System.out.println("Enter the author name:");
                    String author = scan.nextLine().trim();
                    System.out.println("Enter the amount:");
                    int amount = Integer.parseInt(scan.nextLine().trim());

                    ResultBook registerResult = catalog.registerBook(isbn, title, author, amount);

                    if (registerResult == ResultBook.BOOK_EXIST) {
                        System.out.println("---------------------------------------");
                        System.out.println("There is already a book with that ISBN.");
                        System.out.println("---------------------------------------");
                    } else {
                        System.out.println("-----------------------------");
                        System.out.println("Book successfully registered.");
                        System.out.println("-----------------------------");
                    }

                    break;
                    
                case 2: // Vender de Libro
                    System.out.println("Enter the isbn code of the book to buy:");
                    String isbnSell = scan.nextLine();

                    System.out.println("Enter the amount of books:");
                    int amountSell = scan.nextInt();
                    scan.nextLine();

                    ResultBook salesResult = catalog.sellBook(isbnSell, amountSell);

                    if (salesResult == ResultBook.SUCCESSFUL) {
                        System.out.println("----------------------------------------");
                        System.out.println("The purchase was completed successfully.");
                        System.out.println("----------------------------------------");
                    }
                    else if(salesResult == ResultBook.NOT_STOCK) {
                        System.out.println("---------------------------------------------");
                        System.out.println("There are no books in stock for your purchase");
                        System.out.println("---------------------------------------------");
                    } else {
                        System.out.println("--------------------------------------------------");
                        System.out.println("There is no book with that ISBN. Please try again.");
                        System.out.println("--------------------------------------------------");
                    }

                    break;
                case 3:
                    // Show all books of the catalog.
                    ArrayList<Book> books = catalog.getBooks();
                    catalog.showAllBooks(books);

                    break;
                case 4:
                    option = 5;
                    System.out.println("Enter the ISBN of the book you want to find");
                    String searchIsbn = scan.nextLine().trim();

                    catalog.searchBook(searchIsbn);
                    break;
                default:
                    option = 0;
            }

        } while (option != 0);

    }
}

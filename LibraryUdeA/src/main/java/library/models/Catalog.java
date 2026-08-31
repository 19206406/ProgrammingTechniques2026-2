/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.models;

import java.util.ArrayList;

/**
 *
 * @author juanfe
 */
public class Catalog {

    private final ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public Book findByIsbn(String isbn) {
        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getIsbn().equals(isbn)) {
                return books.get(i);
            }
        }

        return null;
    }

    public ResultBook registerBook(String isbn, String title, String author, int amount) {

        Book bookExist = findByIsbn(isbn);

        if (bookExist != null) {
            return ResultBook.BOOK_EXIST;
        }

        Book book = new Book(isbn, title, author, amount);
        books.add(book);

        return ResultBook.SUCCESSFUL;

    }
    
    public ResultBook sellBook(String isbn, int amount){
        Book book = findByIsbn(isbn);
        
        if(book != null && (book.getAmount() - amount) >= 0){
            book.setAmount(book.getAmount() - amount);
            return ResultBook.SUCCESSFUL;
        }
        
        else if(book != null && (book.getAmount() - amount) < 0){
            return ResultBook.NOT_STOCK;
        }
        
        else{
            return ResultBook.NOT_FOUND;
        }
    }

    public void showAllBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("-----------------------------------------");
            System.out.println("There are no books listed in the catalog.");
            System.out.println("-----------------------------------------");
        } else {
            for (Book b : books) {
                System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println("ISBN: " + b.getIsbn()
                        + " | Título: " + b.getTitle()
                        + " | Autor: " + b.getAuthor()
                        + " | Cantidad: " + b.getAmount());
            }
            System.out.println("---------------------------------------------------------------------------------------------------");
        }
    }

    public void searchBook(String isbn) {
        Book searchBook = findByIsbn(isbn);

        if (searchBook == null) {
            System.out.println("--------------------------------------------------");
            System.out.println("There is no book with that ISBN. Please try again.");
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("Book found with the ISBN: " + searchBook.getIsbn());
            System.out.println("                                                   ");
            System.out.println("Book title: " + searchBook.getTitle());
            System.out.println("Author of the book: " + searchBook.getAuthor());
            System.out.println("Number of books available: " + searchBook.getAmount());
            System.out.println("--------------------------------------------------");
        }
    }
}

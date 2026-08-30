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
}

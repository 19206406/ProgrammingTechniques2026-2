/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library.models;

/**
 *
 * @author juanfe
 */
public class Book {

    private final String isbn;
    private String title;
    private String author;
    private int amount;

    public Book() {
        this.isbn = "";
    }

    public Book(String isbn, String title, String author, int amount) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.amount = amount;
    }

    public String getIsbn() {
        return isbn;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}

package com.bookstore.Models;


public class Book {
    private Long id;
    private String title;
    private String author;
    private double price;
    private int stock;

    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }
    public Long getId() {
        return id;
    }
    // public void setId(Long id) {
    //     this.id = id;
    // }
    
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }  
    
}

package com.bookstore.Models;

public class Order {
    private Long id;
    private User user;
    private Book book;
    private int quantity;


    //make constructor
    public Order(User user, Book book, int quantity) {
        this.user = user;
        this.book = book;
        this.quantity = quantity;
    }

    //make getters and setters
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }   

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;   
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }   
    
}

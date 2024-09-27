package com.bookstore.Services;

import com.bookstore.Models.Book;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartService {
    // Map now stores the Book object along with quantity
    private Map<Book, Integer> cart = new HashMap<>();

    // Add book to cart
    public void addToCart(Book book, int quantity) {
        cart.put(book, quantity);
    }

    // Get current cart items
    public Map<Book, Integer> getCart() {
        return cart;
    }

    // Remove item from cart
    public void removeFromCart(Book book) {
        cart.remove(book);
    }

    // Update quantity of an item in cart
    public void updateQuantity(Book book, int newQuantity) {
        if (cart.containsKey(book)) {
            cart.put(book, newQuantity);
        } else {
            System.out.println("Item not in cart.");
        }
    }

    // Clear all items from the cart
    public void clearCart() {
        cart.clear();
    }

    // Get the total number of items in the cart
    public int getTotalItems() {
        return cart.values().stream().mapToInt(Integer::intValue).sum();
    }

    // Calculate the total cost of items in the cart
    public double getCartTotal() {
        double total = 0;
        for (Map.Entry<Book, Integer> entry : cart.entrySet()) {
            Book book = entry.getKey();
            int quantity = entry.getValue();
            total += book.getPrice() * quantity;
        }
        return total;
    }

    // Display a summary of the items in the cart
    public void getCartSummary() {
        for (Map.Entry<Book, Integer> entry : cart.entrySet()) {
            Book book = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(book.getTitle() + " by " + book.getAuthor() + ": " + quantity + " @ $" + book.getPrice() + " each");
        }
    }
}

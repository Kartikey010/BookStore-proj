package com.bookstore;

import com.bookstore.Models.Book;
import com.bookstore.Models.User;
import com.bookstore.Services.BookService;
import com.bookstore.Services.OrderService;
import com.bookstore.Services.ShoppingCartService;
import com.bookstore.Services.UserService;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class App {
    private static final UserService userService = new UserService();
    private static final BookService bookService = new BookService();
    private static final ShoppingCartService shoppingCartService = new ShoppingCartService();
    private static final OrderService orderService = new OrderService();
    private static User loggedInUser = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register User");
            System.out.println("2. Login");
            System.out.println("3. Add Book");
            System.out.println("4. Search Books");
            System.out.println("5. View Shopping Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (option) {
                    case 1:
                        registerUser(scanner);
                        break;
                    case 2:
                        loginUser(scanner);
                        break;
                    case 3:
                        addBook(scanner);
                        break;
                    case 4:
                        searchBooks(scanner);
                        break;
                    case 5:
                        viewCart();
                        break;
                    case 6:
                        checkout();
                        break;
                    case 7:
                        shutdownServices();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private static void registerUser(Scanner scanner) throws InterruptedException, ExecutionException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Register user asynchronously
        Future<Void> registrationFuture = userService.registerUser(username, password);
        registrationFuture.get(); // Wait for completion

        System.out.println("User registered successfully!");
    }

    private static void loginUser(Scanner scanner) throws InterruptedException, ExecutionException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Authenticate user asynchronously
        Future<User> authenticationFuture = userService.authenticate(username, password);
        loggedInUser = authenticationFuture.get(); // Wait for authentication to complete

        if (loggedInUser != null) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter stock: ");
        int stock = scanner.nextInt();
        bookService.addBook(new Book(title, author, price, stock));
        System.out.println("Book added successfully!");
    }

    private static void searchBooks(Scanner scanner) {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();
        List<Book> books = bookService.searchBooks(title);

        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            books.forEach(book -> {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
                System.out.print("Would you like to add this to your cart? (yes/no): ");
                String response = scanner.nextLine();
                if ("yes".equalsIgnoreCase(response)) {
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    shoppingCartService.addToCart(book, quantity);
                    System.out.println("Book added to cart.");
                }
            });
        }
    }

    private static void viewCart() {
        System.out.println("Cart Summary:");
        shoppingCartService.getCartSummary();
        System.out.println("Total items: " + shoppingCartService.getTotalItems());
        System.out.println("Total cost: $" + shoppingCartService.getCartTotal());
    }

    private static void checkout() {
        // Implement checkout logic
        System.out.println("Checkout successful!");
        shoppingCartService.clearCart();
    }

    private static void shutdownServices() {
        orderService.shutdown();
        userService.shutdown();
    }
}

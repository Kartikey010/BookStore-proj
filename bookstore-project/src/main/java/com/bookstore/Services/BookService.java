package com.bookstore.Services;


import com.bookstore.DatabaseConnection;
import com.bookstore.Models.Book;
import com.bookstore.Utils.GuavaCacheUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    public void addBook(Book book) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO books (title, author, price, stock) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDouble(3, book.getPrice());
            statement.setInt(4, book.getStock());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//      public void addBook(Book book) {
//     try (Connection connection = DatabaseConnection.getConnection()) {
//         // Insert the book into the database
//         String sql = "INSERT INTO books (title, author, price, stock) VALUES (?, ?, ?, ?)";
//         PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);  // Get the auto-generated ID
//         statement.setString(1, book.getTitle());
//         statement.setString(2, book.getAuthor());
//         statement.setDouble(3, book.getPrice());
//         statement.setInt(4, book.getStock());
//         statement.executeUpdate();

//         // Get the generated book ID (assuming ID is auto-generated)
//         ResultSet rs = statement.getGeneratedKeys();
//         if (rs.next()) {
//             long bookId = rs.getLong(1);  // Get the auto-generated ID

//             // Set the book ID in the object (if needed)
//             book.setId(bookId);

//             // After successfully adding to the database, cache the book
//             GuavaCacheUtil.put(bookId, book);
//         }

//     } catch (SQLException e) {
//         e.printStackTrace();
//     }
// }





    public List<Book> searchBooks(String title) {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM books WHERE title LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + title + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                books.add(new Book(resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("stock")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}

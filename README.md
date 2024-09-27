--SQL file commands 


create database bookstore;
use bookstore;

CREATE TABLE users (
   id INT AUTO_INCREMENT PRIMARY KEY,
   username VARCHAR(50),
   password VARCHAR(50)
);

select * from users;

select * from books;
-- Drop existing books table if it exists
DROP TABLE IF EXISTS books;

-- Create Books Table
CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50),
    author VARCHAR(50),
    price DOUBLE,
    stock INT
);



-- Create Shopping Cart Table
CREATE TABLE shopping_cart (
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    book_id INT,
    quantity INT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);

-- Create Orders Table
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    total_amount DOUBLE,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Create Order Details Table
CREATE TABLE order_details (
    order_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    book_id INT,
    quantity INT,
    price DOUBLE,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);

-- Insert 50 sample books into the books table
INSERT INTO books (title, author, price, stock) VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', 10.99, 5),
('1984', 'George Orwell', 8.99, 10),
('To Kill a Mockingbird', 'Harper Lee', 7.99, 8),
('Pride and Prejudice', 'Jane Austen', 12.50, 3),
('Moby Dick', 'Herman Melville', 11.99, 6),
('War and Peace', 'Leo Tolstoy', 14.99, 4),
('The Catcher in the Rye', 'J.D. Salinger', 9.99, 7),
('The Hobbit', 'J.R.R. Tolkien', 13.50, 2),
('Fahrenheit 451', 'Ray Bradbury', 10.00, 5),
('The Picture of Dorian Gray', 'Oscar Wilde', 12.00, 4),
('Jane Eyre', 'Charlotte Brontë', 9.00, 5),
('The Grapes of Wrath', 'John Steinbeck', 15.00, 3),
('Brave New World', 'Aldous Huxley', 10.50, 8),
('The Adventures of Huckleberry Finn', 'Mark Twain', 8.50, 10),
('Wuthering Heights', 'Emily Brontë', 11.00, 2),
('The Alchemist', 'Paulo Coelho', 13.00, 5),
('Crime and Punishment', 'Fyodor Dostoevsky', 9.50, 6),
('The Odyssey', 'Homer', 12.75, 7),
('Anna Karenina', 'Leo Tolstoy', 10.50, 4),
('The Brothers Karamazov', 'Fyodor Dostoevsky', 15.50, 3),
('The Old Man and the Sea', 'Ernest Hemingway', 8.75, 9),
('The Bell Jar', 'Sylvia Plath', 11.25, 5),
('Catch-22', 'Joseph Heller', 12.50, 6),
('The Road', 'Cormac McCarthy', 14.00, 3),
('The Handmaid\'s Tale', 'Margaret Atwood', 10.25, 8),
('Little Women', 'Louisa May Alcott', 9.75, 10),
('A Tale of Two Cities', 'Charles Dickens', 11.50, 4),
('Sense and Sensibility', 'Jane Austen', 8.99, 6),
('The Sun Also Rises', 'Ernest Hemingway', 12.99, 5),
('The Kite Runner', 'Khaled Hosseini', 10.50, 6),
('The Fault in Our Stars', 'John Green', 9.99, 4),
('The Hunger Games', 'Suzanne Collins', 12.50, 5),
('Divergent', 'Veronica Roth', 10.99, 7),
('The Maze Runner', 'James Dashner', 11.25, 3),
('The Martian', 'Andy Weir', 14.99, 5),
('The Book Thief', 'Markus Zusak', 9.99, 8),
('Ready Player One', 'Ernest Cline', 12.00, 6),
('The Shadow of the Wind', 'Carlos Ruiz Zafón', 13.50, 4),
('The Night Circus', 'Erin Morgenstern', 10.75, 5),
('Station Eleven', 'Emily St. John Mandel', 11.99, 3),
('The Silent Patient', 'Alex Michaelides', 14.50, 4),
('Where the Crawdads Sing', 'Delia Owens', 12.25, 5),
('Becoming', 'Michelle Obama', 10.50, 6),
('Educated', 'Tara Westover', 11.00, 3),
('Sapiens: A Brief History of Humankind', 'Yuval Noah Harari', 15.99, 4),
('Born a Crime', 'Trevor Noah', 9.99, 5),
('The Immortal Life of Henrietta Lacks', 'Rebecca Skloot', 10.75, 3),
('The Glass Castle', 'Jeannette Walls', 12.00, 6),
('The Wright Brothers', 'David McCullough', 13.50, 5),
('Outliers', 'Malcolm Gladwell', 11.25, 4),
('Thinking, Fast and Slow', 'Daniel Kahneman', 12.75, 6),
('The Power of Habit', 'Charles Duhigg', 10.50, 3),
('The 7 Habits of Highly Effective People', 'Stephen Covey', 15.00, 4),
('The Subtle Art of Not Giving a F*ck', 'Mark Manson', 9.99, 5),
('Atomic Habits', 'James Clear', 11.99, 6);

-- Insert 20 sample users into the users table
INSERT INTO users (username, password) VALUES
('JohnDoe', 'password1'),
('JaneSmith', 'password2'),
('MichaelJohnson', 'password3'),
('EmilyDavis', 'password4'),
('WilliamBrown', 'password5'),
('OliviaJones', 'password6'),
('JamesGarcia', 'password7'),
('SophiaMartinez', 'password8'),
('BenjaminLopez', 'password9'),
('MiaHernandez', 'password10'),
('LucasGonzalez', 'password11'),
('CharlotteWilson', 'password12'),
('ElijahAnderson', 'password13'),
('AmeliaThomas', 'password14'),
('AlexanderTaylor', 'password15'),
('HarperMoore', 'password16'),
('DanielJackson', 'password17'),
('AvaWhite', 'password18'),
('MatthewHarris', 'password19'),
('EllaClark', 'password20');


INSERT INTO shopping_cart (user_id, book_id, quantity) VALUES
(1, 1, 2),  -- User 1 adds 2 copies of Book ID 1
(1, 2, 1),  -- User 1 adds 1 copy of Book ID 2
(2, 3, 3),  -- User 2 adds 3 copies of Book ID 3
(2, 4, 2),  -- User 2 adds 2 copies of Book ID 4
(3, 5, 1),  -- User 3 adds 1 copy of Book ID 5
(4, 1, 1),  -- User 4 adds 1 copy of Book ID 1
(5, 2, 4),  -- User 5 adds 4 copies of Book ID 2
(1, 3, 2),  -- User 1 adds 2 copies of Book ID 3
(2, 5, 1),  -- User 2 adds 1 copy of Book ID 5
(3, 4, 2);  -- User 3 adds 2 copies of Book ID 4



INSERT INTO orders (user_id, total_amount) VALUES
(1, 29.99),  -- User 1 places an order totaling $29.99
(2, 15.50),  -- User 2 places an order totaling $15.50
(3, 45.00),  -- User 3 places an order totaling $45.00
(4, 22.75),  -- User 4 places an order totaling $22.75
(5, 60.20),  -- User 5 places an order totaling $60.20
(1, 30.00),  -- User 1 places another order totaling $30.00
(2, 18.99),  -- User 2 places another order totaling $18.99
(3, 55.50),  -- User 3 places another order totaling $55.50
(4, 33.00),  -- User 4 places another order totaling $33.00
(5, 27.10);  -- User 5 places another order totaling $27.10



INSERT INTO order_details (order_id, book_id, quantity, price) VALUES
(1, 1, 2, 15.00),  -- Order 1 includes 2 copies of Book 1 at $15.00 each
(1, 2, 1, 12.50),  -- Order 1 includes 1 copy of Book 2 at $12.50
(2, 3, 1, 20.00),  -- Order 2 includes 1 copy of Book 3 at $20.00
(3, 1, 1, 15.00),  -- Order 3 includes 1 copy of Book 1 at $15.00
(3, 4, 3, 10.00),  -- Order 3 includes 3 copies of Book 4 at $10.00 each
(4, 5, 1, 25.00),  -- Order 4 includes 1 copy of Book 5 at $25.00
(5, 6, 4, 5.00);    -- Order 5 includes 4 copies of Book 6 at $5.00 each

SELECT * FROM users;
SELECT * FROM books;
SELECT * FROM orders;
SELECT * FROM order_details;

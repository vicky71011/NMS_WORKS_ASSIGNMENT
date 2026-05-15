CREATE DATABASE IF NOT EXISTS library_db;
USE library_db;

CREATE TABLE IF NOT EXISTS books (
    book_id          INT          PRIMARY KEY AUTO_INCREMENT,
    title            VARCHAR(200) NOT NULL,
    author           VARCHAR(150) NOT NULL,
    genre            VARCHAR(80)  NOT NULL,
    total_copies     INT          NOT NULL DEFAULT 1,
    available_copies INT          NOT NULL DEFAULT 1,
    status           VARCHAR(30)  NOT NULL DEFAULT 'Available'
);

CREATE TABLE IF NOT EXISTS borrow_records (
    record_id    INT          PRIMARY KEY AUTO_INCREMENT,
    book_id      INT          NOT NULL,
    student_name VARCHAR(150) NOT NULL,
    borrow_date  VARCHAR(20)  NOT NULL,
    return_date  VARCHAR(20)  DEFAULT NULL,
    status       VARCHAR(20)  NOT NULL DEFAULT 'Borrowed',

    FOREIGN KEY (book_id) REFERENCES books(book_id) ON DELETE CASCADE
);

INSERT INTO books (title, author, genre, total_copies, available_copies, status) VALUES
('The Alchemist',              'Paulo Coelho',        'Fiction',     3, 3, 'Available'),
('Clean Code',                 'Robert C. Martin',    'Technology',  2, 2, 'Available'),
('A Brief History of Time',    'Stephen Hawking',     'Science',     2, 1, 'Available'),
('Atomic Habits',              'James Clear',         'Self-Help',   4, 4, 'Available'),
('The Art of War',             'Sun Tzu',             'History',     1, 0, 'Out of Stock'),
('Introduction to Algorithms', 'Cormen et al.',       'Mathematics', 2, 2, 'Available');

INSERT INTO borrow_records (book_id, student_name, borrow_date, return_date, status) VALUES
(3, 'Pavithra K R', '2024-12-01', NULL,         'Borrowed'),
(5, 'Ravi Kumar',   '2024-11-28', '2024-12-05', 'Returned');

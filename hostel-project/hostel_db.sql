CREATE DATABASE IF NOT EXISTS hostel_db;

USE hostel_db;

CREATE TABLE IF NOT EXISTS students (
    id       INT          PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(100) NOT NULL,
    email    VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS complaints (
    complaint_id   INT          PRIMARY KEY AUTO_INCREMENT,
    student_name   VARCHAR(100) NOT NULL,
    room_no        VARCHAR(20)  NOT NULL,
    complaint_type VARCHAR(100) NOT NULL,
    description    VARCHAR(500),
    status         VARCHAR(20)  NOT NULL DEFAULT 'Pending'
);

CREATE TABLE IF NOT EXISTS visitors (
    visitor_id      INT          PRIMARY KEY AUTO_INCREMENT,
    student_name    VARCHAR(100) NOT NULL,
    visitor_name    VARCHAR(100) NOT NULL,
    visit_time      VARCHAR(50)  NOT NULL,
    approval_status VARCHAR(20)  NOT NULL DEFAULT 'Pending'
);

INSERT INTO students (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin123')
ON DUPLICATE KEY UPDATE name = name;  -- Prevents duplicate if run twice

INSERT INTO complaints (student_name, room_no, complaint_type, description, status) VALUES
('Vignesh S',  'A-101', 'Water Issue',        'No water supply since morning.',  'Pending'),
('Ronaldo',    'B-204', 'WiFi Issue',          'Internet is very slow.',          'Pending'),
('Meena S',       'C-305', 'Electricity Problem', 'Fan is not working in my room.',  'Resolved');

INSERT INTO visitors (student_name, visitor_name, visit_time, approval_status) VALUES
('Vignesh S', 'Suresh K R', '3:00 PM', 'Pending'),
('Ronaldo',   'Anitha Raj', '5:30 PM', 'Approved');

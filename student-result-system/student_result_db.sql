
CREATE DATABASE IF NOT EXISTS student_result_db;
USE student_result_db;

CREATE TABLE IF NOT EXISTS student (
    id             BIGINT       PRIMARY KEY AUTO_INCREMENT,
    student_name   VARCHAR(100) NOT NULL,
    roll_number    VARCHAR(50)  NOT NULL UNIQUE,
    department     VARCHAR(100) NOT NULL,
    subject        VARCHAR(100) NOT NULL,
    marks_obtained INT          NOT NULL,
    total_marks    INT          NOT NULL DEFAULT 100,
    percentage     DOUBLE,
    grade          VARCHAR(5),
    result         VARCHAR(10)
);

INSERT INTO student (student_name, roll_number, department, subject, marks_obtained, total_marks, percentage, grade, result) VALUES
('Vignesh S',   'CS2024001', 'CSE',   'Java Programming',       92, 100, 92.0,  'A+', 'Pass'),
('Yashini S',     'CS2024002', 'CSE',   'Data Structures',        78, 100, 78.0,  'B',  'Pass'),
('Ronaldo',        'IT2024001', 'IT',    'Web Technologies',       85, 100, 85.0,  'A',  'Pass'),
('Messi',   'CS2024003', 'CSE',   'Operating Systems',      65, 100, 65.0,  'C',  'Pass'),
('Neymar',       'EC2024001', 'ECE',   'Digital Electronics',    55, 100, 55.0,  'D',  'Pass'),
('Sachin',     'IT2024002', 'IT',    'Database Management',    35, 100, 35.0,  'F',  'Fail'),
('Rohit',      'CS2024004', 'CSE',   'Computer Networks',      88, 100, 88.0,  'A',  'Pass'),
('Mbappae',        'ME2024001', 'MECH',  'Engineering Mechanics',  72, 100, 72.0,  'B',  'Pass');

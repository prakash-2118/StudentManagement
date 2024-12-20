CREATE DATABASE studentManagement;

USE studentManagement;

CREATE TABLE students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    year INT,
    cgpa DOUBLE
);

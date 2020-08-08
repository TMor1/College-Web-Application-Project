/* ===== This File Shows The SQL File Used on MySQL Workbench ===== */

/* ===== Create/Select the database ===== */
DROP DATABASE IF EXISTS freeBirdStudio;
CREATE DATABASE freeBirdStudio;
USE freeBirdStudio;

/* ===== Create the workshop table ===== */
CREATE TABLE workshop(
    idWorkshop int(20) NOT NULL,
    daySelect int(2),
    monthSelect varchar(20),
    grade varchar(20),
    price int(20),
    PRIMARY KEY (idWorkshop)
);
/* ===== Insert values into workshop table ===== */
INSERT INTO workshop (idWorkshop, daySelect, monthSelect, grade, price)
VALUES 
('1', '11', 'July', 'Beginner', '50'), 
('2', '18', 'July', 'Intermediate', '60'), 
('3', '1', 'August', 'Advanced', '80'),  
('4', '15', 'August', 'Beginner', '50'), 
('5', '12', 'September', 'Intermediate', '60'), 
('6', '19', 'September', 'Advanced', '80'), 
('7', '26', 'September', 'Beginner', '50'), 
('8', '10', 'October', 'Beginner', '50'), 
('9', '17', 'October', 'Intermediate', '60'), 
('10', '31', 'October', 'Beginner', '50'), 
('11', '7', 'November', 'Advanced', '80'), 
('12', '14', 'November', 'Beginner', '50'), 
('13', '21', 'November', 'Intermediate', '60'), 
('14', '5', 'December', 'Beginner', '50'), 
('15', '12', 'December', 'Advanced', '80') 
;
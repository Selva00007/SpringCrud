DROP TABLE  Carcollections;
CREATE TABLE if NOT EXISTS Carcollections (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    customertnno INT,
    customername VARCHAR(50),
    customerdate VARCHAR(50),
    customercar VARCHAR(50)
);

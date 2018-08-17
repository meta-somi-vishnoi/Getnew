CREATE DATABASE StoreFront;

USE StoreFront;

CREATE TABLE Categories(
    CategoryId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ParentId INT,
    CategoryName VARCHAR(100)
    );

CREATE TABLE Product(
    ProductId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    CategoryId INT,
    Price INT,
    Description VARCHAR(100),
    Quantity INT,
    Name VARCHAR(100),
    FOREIGN KEY (CategoryId) REFERENCES Categories(CategoryId)
    );

CREATE TABLE ProductImages(
    ProductId INT,
    Image VARCHAR(100),
    FOREIGN KEY (ProductId) REFERENCES Product(ProductId)
    );

CREATE TABLE Users(
    UserId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    FirstName VARCHAR(100),
    LastName VARCHAR(100),
    EmailId VARCHAR(100) UNIQUE,
    Password VARCHAR(100),
    DateOfBirth DATE,
    Gender VARCHAR(10) CHECK (Gender IN ("Male","Female"))
    );

CREATE TABLE UserContactDetails(
    UserId INT,
    ContactNumber VARCHAR(20),
    FOREIGN KEY (UserId) REFERENCES Users(UserId)
    );

CREATE TABLE UserAddress(
    UserId INT,
    AddressId INT AUTO_INCREMENT PRIMARY KEY,
    StreetNumber VARCHAR(50),
    StreetName VARCHAR(100),
    CityName VARCHAR(100),
    State VARCHAR(50),
    PostalZip INT,
    FOREIGN KEY (UserId) REFERENCES Users(UserId)
    );

CREATE TABLE Cart(
    UserId INT,
    ProductId INT,
    Quantity INT,
    TotalPrice INT,
    FOREIGN KEY (ProductId) REFERENCES Product(ProductId),
    FOREIGN KEY (UserId) REFERENCES Users(UserId)
    );

CREATE TABLE OrderedItems(
    OrderId INT AUTO_INCREMENT PRIMARY KEY,
    UserId INT,
    OrderDate DATE,
    ShippingAddressId INT,
    Quantity INT,
    FOREIGN KEY (UserId) REFERENCES Users(UserId),
    FOREIGN KEY (ShippingAddressId) REFERENCES UserAddress(AddressId)
    );


CREATE TABLE Items(
    OrderId INT,
    ProductId INT,
    Quantity INT,
    TotalPrice INT,
    OrderStatus VARCHAR(100),
    FOREIGN KEY (ProductId) REFERENCES Product(ProductId)
    );

SHOW TABLES;


DROP TABLE Items;
DROP TABLE Cart;
DROP TABLE ProductImages;
DROP TABLE Product;
CREATE TABLE Product(
    ProductId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    CategoryId INT,
    Price INT,
    Description VARCHAR(100),
    Quantity INT,
    Name VARCHAR(100),
    FOREIGN KEY (CategoryId) REFERENCES Categories(CategoryId)
    );
CREATE TABLE ProductImages(
    ProductId INT,
    Image VARCHAR(100),
    FOREIGN KEY (ProductId) REFERENCES Product(ProductId)
    );
CREATE TABLE Cart(
    UserId INT,
    ProductId INT,
    Quantity INT,
    TotalPrice INT,
    FOREIGN KEY (ProductId) REFERENCES Product(ProductId),
    FOREIGN KEY (UserId) REFERENCES Users(UserId)
    );
CREATE TABLE Items(
    OrderId INT,
    ProductId INT,
    Quantity INT,
    TotalPrice INT,
    OrderStatus VARCHAR(100),
    FOREIGN KEY (ProductId) REFERENCES Product(ProductId)
    );

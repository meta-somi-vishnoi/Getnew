#Question 2

#Display the list of products (Id, Title, Count of Categories) 
#which fall in more than one Categories.
SELECT p.ProductId, p.Name, COUNT(*) AS CategoryCount
FROM Product p, ProductCategory c
WHERE p.ProductId = c.ProductId
GROUP BY c.ProductId;

#Display Count of products as per below price range
SELECT
SUM(CASE WHEN Price < 500 THEN 1 ELSE 0 END) AS PriceRange_0_500,
SUM(CASE WHEN Price >= 500 AND Price < 2000 THEN 1 ELSE 0 END) AS PriceRange_500_2000,
SUM(CASE WHEN Price >= 2000 THEN 1 ELSE 0 END) AS PriceRange_2000Above
FROM Product

#Display the Categories along with number of products under each category.
SELECT s.CategoryId, c.CategoryName, COUNT(*) AS ProductCount
FROM Categories c, ProductCategory s
WHERE c.CategoryId = s.CategoryId
GROUP BY s.CategoryId;


#Question 3

#Display Shopper’s information along with number of orders he/she
#placed during last 30 days.
SELECT Users.UserId, Users.FirstName, Users.LastName, COUNT(*) AS CountOfOrder
FROM Users INNER JOIN OrderedItems
ON Users.UserId = OrderedItems.UserId
WHERE OrderDate >= (DATE_SUB(NOW(), INTERVAL 30 DAY))
GROUP BY OrderedItems.UserId;

#Display the top 10 Shoppers who generated maximum number of revenue
#in last 30 days.
SELECT Users.UserId, Users.FirstName, Users.LastName
FROM Users INNER JOIN
                    (SELECT Items.OrderId, OrderedItems.UserId, SUM(TotalPrice) AS Price
                    FROM OrderedItems INNER JOIN Items
                    ON Items.OrderId = OrderedItems.OrderId
                    WHERE OrderedItems.OrderDate >= (DATE_SUB(NOW(), INTERVAL 30 DAY))
                    GROUP BY OrderedItems.UserId) AS OrderTotal
ON Users.UserId = OrderTotal.UserId
ORDER BY OrderTotal.Price DESC
LIMIT 10
;

#Display top 20 Products which are ordered most in last 60 days 
#along with numbers.
SELECT Product.ProductId, Product.Name, COUNT(*) AS ProductCount
FROM Items INNER JOIN Product 
ON Items.ProductId = Product.ProductId 
WHERE Items.OrderId IN 
                      (SELECT OrderId
                       FROM OrderedItems 
                       WHERE OrderDate >= (DATE_SUB(NOW(), INTERVAL 60 DAY))
                      )
GROUP BY Items.ProductId
LIMIT 20;

#Display Monthly sales revenue of the StoreFront for last 6 months. 
#It should display each month’s sale.
SELECT Month, SUM(Price) AS MonthlySales
FROM
    (SELECT Items.OrderId, MONTH(OrderedItems.OrderDate) AS Month, SUM(TotalPrice) AS Price
    FROM OrderedItems INNER JOIN Items
    ON Items.OrderId = OrderedItems.OrderId
    GROUP BY Items.OrderId) AS OrderPrice
WHERE Month >= MONTH(CURDATE()) - 6
GROUP BY Month
ORDER BY MonthlySales DESC;

#Mark the products as Inactive which are not ordered in last 90 days.
UPDATE Product 
SET Quantity = 0
WHERE ProductId IN
                  (SELECT ProductId
                   FROM Items
                   WHERE OrderId IN
                                   (SELECT OrderId
                                    FROM OrderedItems 
                                    WHERE OrderDate >= (DATE_SUB(NOW(), INTERVAL 90 DAY))
                                   )
                  );

#Given a category search keyword, display all the Products present in this 
#category/categories. 
SELECT p.ProductId, p.Name, c.CategoryName 
FROM Product p, Categories c, ProductCategory o
WHERE p.ProductId = o.ProductId AND
o.CategoryId = c.CategoryId AND
c.CategoryName IN ("Dresses", "Slippers");

#Display top 10 Items which were cancelled most.
SELECT Product.ProductId, Product.Name, COUNT(*) AS ProductCount
FROM Items INNER JOIN Product 
ON Items.ProductId = Product.ProductId 
WHERE Items.OrderStatus = "Cancelled"
GROUP BY Items.ProductId
ORDER BY ProductCount DESC
LIMIT 10;

#Question 5

#Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
#with latest ordered items should be displayed first for last 60 days.
CREATE VIEW UserOrderedProduct 
    AS
        SELECT Items.OrderId, Product.Name, Items.ProductId, Items.TotalPrice, Users.FirstName,
            Users.LastName, Users.EmailId, OrderedItems.OrderDate, Items.OrderStatus
        FROM Product
        INNER JOIN
        OrderedItems 
        INNER JOIN Users 
        ON Users.UserId = OrderedItems.UserId
        INNER JOIN Items
        ON Items.OrderID = OrderedItems.OrderId AND
        Items.ProductId = Product.ProductId
        WHERE OrderedItems.OrderDate >= (DATE_SUB(NOW(), INTERVAL 60 DAY))
        ORDER BY OrderedItems.OrderDate DESC
    ;
    
#Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT Name, OrderStatus
FROM UserOrderedProduct
WHERE OrderStatus = "Shipped";

#Use the above view to display the top 5 most selling products.
SELECT Name, COUNT(*) AS Count
FROM UserOrderedProduct
GROUP BY ProductId
ORDER BY Count DESC
LIMIT 5;


#Question 4

CREATE DATABASE PostalZip;

CREATE TABLE State(
    StateId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    State VARCHAR(50)
    );
    
CREATE TABLE City(
    CityId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    StateId INT,
    CityName VARCHAR(50),
    FOREIGN KEY (StateId) REFERENCES State(StateId)
    );
    
CREATE TABLE PostalZip(
    ZipId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ZipCode INT
    );
    
CREATE TABLE ZipCityMapping(
    ZipId INT,
    CityId INT,
    FOREIGN KEY (ZipId) REFERENCES PostalZip(ZipId),
    FOREIGN KEY (CityId) REFERENCES City(CityId)
    );
    
INSERT INTO State
(State)
VALUES 
("Gujarat"),
("Rajasthan"),
("MP"),
("UP"),
("Assam"),
("Kerala");

INSERT INTO City
(StateId, CityName)
VALUES
(1, "Vadodara"),
(1, "Bhuj"),
(1, "Surat"),
(2, "Jaipur"),
(2, "Jodhpur"),
(2, "Bikaner"),
(2, "Chittor"),
(3, "Bhopal"),
(3, "Ganganar"),
(4, "Lucknow"),
(4, "Agra"),
(4, "Barelli"),
(5, "Sikkim"),
(5, "Gangtok"),
(6, "Thiruvanthpuram"),
(6, "Chennai"),
(6, "Bijara");

INSERT INTO PostalZip
(ZipCode)
VALUES
(785898),
(467354),
(467346),
(787898),
(398940),
(467534);

INSERT INTO ZipCityMapping
(ZipId, CityId)
VALUES
(1, 4),
(6, 4),
(4, 8),
(1, 6),
(4, 7),
(3, 7),
(5, 1),
(3, 9),
(2, 16),
(4, 11);

SELECT 
FROM ZipCityMapping
INNER JOIN PostalZip
ON ZipCityMapping.ZipId = PostalZip.ZipId
INNER JOIN City
ON ZipCityMapping.CityId = City.Cityid
WHERE ZipCode = 785898;
USE StoreFront;

#Create a function to calculate number of orders in a month. Month and year 
#will be input parameter to function.

DELIMITER $$
CREATE FUNCTION NumberOfOrdersInMonth(month INT, year INT) RETURNS INT
    DETERMINISTIC
    BEGIN
        DECLARE orderCount INT;
        SELECT COUNT(*) INTO orderCount
        FROM OrderedItems 
        WHERE MONTH(OrderDate) = month AND
        YEAR(OrderDate) = year;
        RETURN (orderCount);
    END$$
SELECT NumberOfOrdersInMonth(8,2018);


#Create a function to return month in a year having maximum orders. 
#Year will be input parameter.

DELIMITER $$
CREATE FUNCTION MaximumOrdersInMonth(yearValue INT) 
    RETURNS INT
    DETERMINISTIC
    BEGIN
        DECLARE monthValue INT;
        SELECT orderMonth INTO monthValue
        FROM 
        (SELECT SUM(o.quantity) AS sales, MONTH(o.OrderDate) AS orderMonth
        FROM OrderedItems o
        WHERE YEAR(o.OrderDate) = yearValue
        GROUP BY MONTH(o.OrderDate)
        ORDER BY sales DESC) AS orderInMonth
        LIMIT 1;
        RETURN (monthValue);
    END$$
SELECT MaximumOrdersInMonth(2018);

  
#Create a Stored procedure to retrieve average sales of each product in 
#a month. Month and year will be input parameter to function.

DELIMITER $$
CREATE PROCEDURE AveargeSalesInMonth(monthValue INT, yearValue INT) 
    BEGIN
        SELECT p.ProductId, p.Name, AVG(i.Totalprice) AS AverageSales
        FROM Items i
        INNER JOIN OrderedItems o
        ON i.OrderId = o.OrderId
        INNER JOIN Product p
        ON i.ProductId = p.ProductId
        WHERE MONTH(o.OrderDate) = monthValue AND
        YEAR(o.OrderDate) = yearValue
        GROUP BY i.ProductId;
    END$$
CALL AveargeSalesInMonth(6, 2018);


#Create a stored procedure to retrieve table having order detail with status 
#for a given period. Start date and end date will be input parameter. 
#Put validation on input dates like start date is less than end date. 
#If start date is greater than end date take first date of month as start date.

DELIMITER $$ 
   CREATE FUNCTION ValidateDate(startDate Date,endDate Date)
   RETURNS Date
   BEGIN
       IF (startDate < endDate )
           THEN
               RETURN startDate;
           ELSE
               RETURN CONCAT(DATE_FORMAT(endDate, '%Y-%m-'), '01');
       END IF;
   END$$
 
DELIMITER $$
CREATE PROCEDURE OrdersInDuration(startDate Date, endDate Date) 
    BEGIN
        DECLARE dateOfOrder DATE;
        SET startDate = ValidateDate(startDate, endDate);
        SELECT o.OrderId, o.UserId, i.ProductId, i.OrderStatus, o.OrderDate
        FROM OrderedItems o
        INNER JOIN Items i
        ON i.OrderId = o.OrderId
        WHERE o.OrderDate > StartDate AND
        o.OrderDate < endDate;
    END$$
CALL OrdersInDuration('2018-02-01','2018-08-10');


#Identify the columns require indexing in order, product, category tables and 
#create indexes.

ALTER TABLE Categories ADD INDEX indexOnParentId(ParentId);
ALTER TABLE Categories ADD UNIQUE indexOnCategoryName(CategoryName);
ALTER TABLE ProductCategory ADD INDEX indexOnCategoryId(CategoryId);
ALTER TABLE ProductCategory ADD INDEX indexOnProductId(ProductId);
ALTER TABLE Product ADD UNIQUE indexOnProductName(Name);
ALTER TABLE OrderedItems ADD INDEX indexOnOrderDate(OrderDate);
ALTER TABLE OrderedItems ADD INDEX indexOnUserId(UserId);
ALTER TABLE Items ADD INDEX indexOnOrderId(OrderId);
ALTER TABLE Items ADD INDEX indexOnItemsProductId(ProductId);
ALTER TABLE Items ADD INDEX indexOnOrderStatus(OrderStatus);
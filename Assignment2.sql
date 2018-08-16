USE StoreFront;

#Question2 

#Part 2
SELECT p.ProductId, p.Name, c.CategoryName, p.Price
FROM Product p, Categories c
WHERE p.CategoryId = c.CategoryId AND 
p.Quantity > 0
ORDER BY p.ProductId DESC;

#Part 3
SELECT ProductId, Name
FROM Product p
WHERE ProductId NOT IN( SELECT ProductId 
                          FROM ProductImages
                        );

#Part 4
SELECT c.CategoryId, c.CategoryName, IFNULL(s.CategoryName, "Top Category") AS ParentCategory
FROM Categories c LEFT JOIN Categories s
ON c.ParentId = s.CategoryId
ORDER BY s.CategoryName, c.CategoryName;

#Part 5
SELECT b.CategoryId, b.CategoryName, IFNULL(l.CategoryName, "Top Category") AS ParentTitle
FROM Categories b LEFT JOIN Categories l
ON b.ParentId = l.CategoryId
WHERE b.CategoryId NOT IN(
                          SELECT s.CategoryId
                          FROM Categories s INNER JOIN Categories c
                          ON s.ParentId = c.CategoryId
                          );

#Part 6
 SELECT p.Name, p.Price, p.Description
 FROM Product p , Categories a
 WHERE a.CategoryName = "Mobiles" AND
 p.CategoryId = a.CategoryId;
 
 #Part 7
 SELECT * 
 FROM Product
 WHERE Quantity <= 50;
 
 #Part 8
 UPDATE Product
 SET Product.Quantity = Quantity + 100;
 
 
#Question 3 

#Part 1
SELECT o.OrderId, o.OrderDate, SUM(i.TotalPrice) AS Total
FROM OrderedItems o, Items i
GROUP BY i.OrderId
ORDER BY OrderDate DESC
LIMIT 50;
 
 #Part 2
 SELECT o.OrderId, o.UserId, o.OrderDate, o.Quantity, SUM(i.TotalPrice) AS Total
 FROM OrderedItems o, Items i
 GROUP BY i.OrderId
 ORDER BY Total
 LIMIT 10;
 
 #Part 3
 SELECT o.OrderId, o.UserId, o.OrderDate
 FROM OrderedItems o
 WHERE OrderDate < (DATE_SUB(NOW(), INTERVAL 10 DAY)) AND
 (SELECT COUNT(i.OrderStatus)
 FROM Items i
 WHERE i.OrderStatus = "Not Shipped" AND
 i.OrderId = o.OrderId
 )>1;
 
 #Part 4
 SELECT * 
 FROM Users u
 WHERE u.UserId NOT IN (
                        SELECT UserId 
                        FROM OrderedItems
                        WHERE OrderDate >= (DATE_SUB(NOW(), INTERVAL 30 DAY))
                        );

#Part 5
CREATE VIEW UserOrder
    AS
    SELECT Users.UserId, Users.FirstName, Users.LastName, OrderedItems.OrderId, OrderedItems.OrderDate
    FROM Users INNER JOIN OrderedItems
    ON Users.UserId = OrderedItems.UserId
    WHERE OrderDate >= (DATE_SUB(NOW(), INTERVAL 15 DAY));
SELECT s.UserId, s.FirstName, s.LastName , s.OrderDate, i.ProductId, i.TotalPrice
FROM Items i, UserOrder s
WHERE i.OrderId = s.OrderId    
;

#Part 6
SELECT * 
FROM Items 
WHERE OrderId = 1 AND
OrderStatus = "Shipped";

#Part 7
SELECT OrderedItems.OrderId, SUM(Items.TotalPrice)  
FROM Items INNER JOIN OrderedItems 
WHERE SUM(TotalPrice) BETWEEN 10 AND 5000;
GROUP BY Items.OrderId;

#Part 8
UPDATE Items INNER JOIN OrderedItems
SET OrderStatus = "Shipped"
WHERE OrderDate = DATE(NOW()) 
ORDER BY OrderDate DESC
LIMIT 20;
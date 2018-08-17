USE StoreFront;

#Question2 

#Part 2
SELECT p.ProductId, p.Name, c.CategoryName, p.Price
FROM Product p, Categories c, ProductCategory a
WHERE a.CategoryId = c.CategoryId AND 
p.ProductId = a.ProductId AND
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
                          ON s.CategoryId = c.ParentId
                          );

#Part 6
 SELECT p.Name, p.Price, p.Description
 FROM Product p , Categories a, ProductCategory c
 WHERE a.CategoryName = "Mobiles" AND
 c.CategoryId = a.CategoryId AND
 c.ProductId = p.ProductId;
 
 #Part 7
 SELECT * 
 FROM Product
 WHERE Quantity <= 50;
 
 #Part 8
 UPDATE Product
 SET Quantity = (Quantity + 100)
 WHERE ProductId > 0;
 
 
#Question 3 

#Part 1
SELECT i.OrderId, o.OrderDate, SUM(i.TotalPrice) AS Total
FROM OrderedItems o, Items i
WHERE i.OrderId = o.OrderId
GROUP BY i.OrderId
ORDER BY o.OrderDate DESC
LIMIT 50;
 
 #Part 2
 SELECT i.OrderId, o.UserId, o.OrderDate, o.Quantity, SUM(i.TotalPrice) AS Total
 FROM OrderedItems o, Items i
 WHERE i.OrderId = o.OrderId
 GROUP BY i.OrderId
 ORDER BY Total DESC
 LIMIT 10;
 
#Part 3
SELECT * 
FROM OrderedItems
WHERE OrderDate NOT BETWEEN DATE_SUB(NOW(), INTERVAL 10 DAY) AND NOW()
AND OrderId IN (SELECT OrderId
                FROM Items
                WHERE OrderStatus = 'Not Shipped'
                );
                 
 #Part 4
 SELECT u.UserId, u.FirstName, u.LastName
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
SELECT s.UserId, s.FirstName, s.LastName , s.OrderDate, s.OrderId, i.ProductId, i.TotalPrice
FROM Items i, UserOrder s
WHERE i.OrderId = s.OrderId    
;

#Part 6
SELECT * 
FROM Items 
WHERE OrderId = 1 AND
OrderStatus = "Shipped";

#Part 7
SELECT Items.OrderId, Items.ProductId, OrderedItems.OrderDate, Product.Price
FROM Items 
INNER JOIN OrderedItems 
ON Items.OrderId = OrderedItems.OrderId
INNER JOIN Product
ON Items.ProductId = Product.ProductId
WHERE Product.Price BETWEEN 10 AND 5000;

#Part 8
UPDATE Items
SET Items.OrderStatus = "Shipped"
WHERE OrderId IN(
                 SELECT OrderId
                 FROM OrderedItems
                 WHERE OrderDate = CURDATE() 
                 )
LIMIT 20;

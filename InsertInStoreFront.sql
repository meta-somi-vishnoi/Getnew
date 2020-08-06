USE StoreFront;

#Question 2

#Part 1
INSERT INTO Categories
(ParentId, CategoryName)
VALUES
(NULL, "Electronic_Gadgets"),
(NULL, "Clothing"),
(NULL, "Footwear"),
(1, "Laptops"),
(1, "Cameras"),
(1, "Mobiles"),
(2, "Mens_Wear"),
(2, "Womens_Wear"),
(2, "Kids_Wear"),
(3, "Slippers"),
(3, "Shoes"),
(7, "Jeans"),
(7, "Shirt"),
(8, "Sarees"),
(8, "Topper"),
(8, "Kurtis"),
(9, "Jackets"),
(9, "Dresses");

INSERT INTO Product
(Price, Description, Quantity, Name)
VALUES
(3000,"Comfortable, Smart", 20, "SportShoes"),
(2000,"Flat Sole, Shimmering", 500, "SneakersShoes"),
(50,"1 year warranty, Daily wear", 10, "FlatsSlippers"),
(2000,"Blue Color, Denim", 30, "LevisJeans"),
(4000,"Black color, Ankle", 200, "WoodlandJeans"),
(100,"White color, Round neck", 3000, "AdidasShirt"),
(1500,"Black color, Party wear", 20, "ReebokShirt"),
(5000,"Beautiful, Red color, Limited stock", 150, "SilkSaree"),
(7000,"Green color, Party wear, Light weight", 40, "CheffonSaree"),
(200,"Free length, Blue color", 0, "CottonSaree"),
(2500,"Purple color, Off shoulder", 30, "PeopleTop"),
(1500,"Black color, Striped", 120, "MaxTop"),
(2000,"Floor length", 600, "AnarkaliKurti"),
(130,"Parrot green color", 0, "ShortKurtis"),
(500,"Woollen, Red black color", 1100, "LittleJackets"),
(3000,"Half sleeves, comfortable, woollen", 70, "JiniJackets"),
(2000,"Beautiful, Dress, pink color", 200, "GirlsDress"),
(150,"Smart shirt and pant pair, Tie", 10, "BoysDress"),
(47000,"15Inch display, Black", 1700, "LenovoLaptop"),
(70000,"I7 processor, Graphic card", 20, "DellLaptop"),
(50000,"Red color, 8GB RAM", 40, "SamsungLaptop"),
(65000,"HD Quality", 70, "CanonCamera"),
(1700,"Slim, Light weight, Rose gold color", 220, "LenovoMobile"),
(25000,"40 MP front caera, 4GB RAM", 410, "MIMobile");

INSERT INTO ProductCategory
(ProductId, CategoryId) 
VALUES
(1, 11),
(2, 11),
(3, 10),
(4, 12),
(5, 12),
(6, 13),
(7, 13),
(8, 14),
(9, 14),
(10, 14),
(11, 15),
(12, 15),
(13, 16),
(14, 16),
(15, 17),
(16, 17),
(17, 18),
(18, 18),
(19, 4),
(20, 4),
(21, 4),
(22, 5),
(23, 6),
(24, 6),
(18, 7),
(18, 9),
(14, 18),
(13, 18),
(3, 7),
(3, 8),
(3, 9);

INSERT INTO ProductImages 
(ProductId, Image) 
VALUES
(1, "ShoesImg.jpg"),
(1, "ShoesBack.jpg"),
(3, "FlatSlipper.jpg"),
(4, "JeansFront.png"),
(4, "JeansBack.jpg"),
(6, "AdidasShirtFront.jpg"),
(6, "AdidasShirtBack.jpg"),
(7, "ReebokFront.jpg"),
(8, "SareeFront.jpg"),
(8, "SareeSideView.jpg"),
(9, "CheffonSaree.jpg"),
(11, "PeopleTopFront.jpg"),
(11, "PeopleTopBack.jpg"),
(12, "MaxTop.jpg"),
(13, "Kurtis.jpg"),
(15, "JacketFront.jpg"),
(15, "JacketBack.jpg"),
(17, "GirlsDress.jpg"),
(17, "Frock.jpg"),
(18, "BoysDress.jpg"),
(18, "ShortSkirtDress.jpg"),
(18, "LongSkirtDress.jpg"),
(19, "LenovoLaptop.jpg"),
(20, "DellLaptop.png"),
(20, "DellLaptopColor.png"),
(22, "Camera.jpg"),
(23, "LenovoMobile.jpg"),
(23, "LenovoMobileSideView.jpg"),
(24, "MIMoblie.jpg"),
(24, "MIMobileSideView.jpg"),
(24, "MIMobileRear.jpg");

INSERT INTO Users
(FirstName, LastName, Password, EmailId, DateOfBirth, Gender)
VALUES
("John", "William", "1234", "john@gmail.com", '2009-10-01', "Male"),
("Harry", "Gupta", "672363", "harry@gmail.com", '1990-05-20', "Male"),
("Priya", "Sharma", "87433","priya@gmail.com", '2013-08-30', "Female"),
("Raj", "Rai", "74344","raj@gmail.com", '2012-10-14', "Male"),
("Sita", "Das", "34221","sita@gmail.com", '1997-11-07', "Female"),
("Anu", "Gupta", "1277","anu@gmail.com", '1877-12-03', "Female");

INSERT INTO UserContactDetails
(UserId, ContactNumber)
VALUES
(1, "8736127123"),
(1, "3748974907"),
(2, "8737838938"),
(3, "8736342123"),
(1, "9736127129"),
(4, "7263787121"),
(5, "8734447128"),
(6, "3478677433"),
(5, "9376736784");

INSERT INTO Address
(StreetNumber, StreetName, CityName, State, PostalZip)
VALUES
("A-13", "Nehru Marg", "Jaipur", "Rajasthan", 372488),
("D-14", "Bapu Nagar", "Delhi", "UP", 348548),
("F/123", "Mansarovar", "Jaipur", "Rajasthan", 337718),
("U-144", "JLN Marg", "Jaipur", "Rajasthan", 672485),
("P/34", "Gopal Marg", "Jaipur", "Rajasthan", 272486),
("A-122", "Patel Nagar", "Vadodara", "Gujarat", 756999),
("C-76", "Shastri Circle", "Jodhpur", "Rajasthan", 420118),
("H-67", "Lajpat Marg", "Mumbai", "Maharashtra", 322487);

INSERT INTO UserAddress
(UserId, AddressId)
VALUES 
(1, 1),
(2, 2),
(1, 3),
(3, 4),
(4, 5),
(4, 6),
(5, 7),
(6, 8),
(6, 4);

INSERT INTO Cart
(UserId, ProductId, Quantity, TotalPrice)
VALUES
(2, 3, 2, 100),
(3, 15, 1, 500),
(2, 22, 2, 130000),
(3, 19, 4, 188000),
(6, 13, 1, 2000),
(2, 21, 5, 250000),
(4, 2, 2, 4000);

INSERT INTO OrderedItems
(UserId , OrderDate, ShippingAddressId, Quantity)
VALUES
(2, '2018-08-10', 2, 2),
(3, '2018-08-10', 3, 1),
(2, '2018-07-15', 2, 1),
(6, '2018-05-01', 8, 1),
(4, '2018-06-10', 6, 2);

INSERT INTO Items
(OrderId, ProductId, Quantity, TotalPrice, OrderStatus)
VALUES
(1, 3, 1, 50, "Not Shipped"),
(1, 22, 1, 65000, "Shipped"),
(2, 19, 1, 47000, "Not Shipped"),
(3, 22, 1, 65000, "Not Shipped"),
(4, 13, 1, 2000, "Not Shipped"),
(5, 2, 2, 4000, "Shipped");

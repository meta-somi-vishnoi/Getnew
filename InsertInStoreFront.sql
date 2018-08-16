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
(CategoryId, Price, Description, Quantity, Name)
VALUES
(11, 3000,"Comfortable, Smart", 20, "SportShoes"),
(11, 2000,"Flat Sole, Shimmering", 500, "SneakersShoes"),
(10, 50,"1 year warranty, Daily wear", 10, "FlatsSlippers"),
(12, 2000,"Blue Color, Denim", 30, "LevisJeans"),
(12, 4000,"Black color, Ankle", 200, "WoodlandJeans"),
(13, 100,"White color, Round neck", 3000, "AdidasShirt"),
(13, 1500,"Black color, Party wear", 20, "ReebokShirt"),
(14, 5000,"Beautiful, Red color, Limited stock", 150, "SilkSaree"),
(14, 7000,"Green color, Party wear, Light weight", 40, "CheffonSaree"),
(14, 200,"Free length, Blue color", 0, "CottonSaree"),
(15, 2500,"Purple color, Off shoulder", 30, "PeopleTop"),
(15, 1500,"Black color, Striped", 120, "MaxTop"),
(16, 2000,"Floor length", 600, "AnarkaliKurti"),
(16, 130,"Parrot green color", 0, "ShortKurtis"),
(17, 500,"Woollen, Red black color", 1100, "LittleJackets"),
(17, 3000,"Half sleeves, comfortable, woollen", 70, "JiniJackets"),
(18, 2000,"Beautiful, Dress, pink color", 200, "GirlsDress"),
(18, 150,"Smart shirt and pant pair, Tie", 10, "BoysDress"),
(4, 47000,"15Inch display, Black", 1700, "LenovoLaptop"),
(4, 70000,"I7 processor, Graphic card", 20, "DellLaptop"),
(4, 50000,"Red color, 8GB RAM", 40, "SamsungLaptop"),
(5, 65000,"HD Quality", 70, "CanonCamera"),
(6, 1700,"Slim, Light weight, Rose gold color", 220, "LenovoMobile"),
(6, 25000,"40 MP front caera, 4GB RAM", 410, "MIMobile");

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

INSERT INTO UserAddress
(UserId, StreetNumber, StreetName, CityName, State, PostalZip)
VALUES 
(1, "A-13", "Nehru Marg", "Jaipur", "Rajasthan", 372488),
(2, "D-14", "Bapu Nagar", "Delhi", "UP", 348548),
(1, "F/123", "Mansarovar", "Jaipur", "Rajasthan", 337718),
(3, "U-144", "JLN Marg", "Jaipur", "Rajasthan", 672485),
(4, "P/34", "Gopal Marg", "Jaipur", "Rajasthan", 272486),
(4, "A-122", "Patel Nagar", "Vadodara", "Gujarat", 756999),
(5, "C-76", "Shastri Circle", "Jodhpur", "Rajasthan", 420118),
(6, "H-67", "Lajpat Marg", "Mumbai", "Maharashtra", 322487);

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
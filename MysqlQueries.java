package javamysqlconnectivity;

class MysqlQueries {
    
    public String getQueryForUser() {
        return "SELECT o.OrderId AS OrderId, o.OrderDate AS OrderDate, SUM(i.TotalPrice) AS TotalPrice "
            + "FROM OrderedItems o "
            + "INNER JOIN Items i "
            + "ON i.OrderId = o.OrderId "
            + "WHERE o.UserId = ? AND i.OrderStatus = ? "
            + "GROUP BY i.OrderId "
            + "ORDER BY o.OrderDate DESC ";
    }
    
    public String getQueryForImageInsert() {
        return "INSERT INTO ProductImages (ProductId, Image) VALUES(?,?)";
    }
    
    public String getQueryForDeleteProduct() {
        return "UPDATE Product " 
            + "SET Status = 'Inactive' "
            + " WHERE ProductId NOT IN( "
            + "SELECT Items.ProductId as ProductId "
            + "FROM Items INNER JOIN OrderedItems "
            + "ON Items.OrderId = OrderedItems.OrderId "
            + "WHERE OrderDate >= DATE_SUB(NOW(), INTERVAL 1 YEAR) "
            + ")";
    }
    
    public String getQueryDisplay() {
        return "SELECT CategoryId, ParentId, CategoryName "
            + "FROM Categories";
    }
}

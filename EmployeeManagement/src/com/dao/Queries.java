package com.dao;

public class Queries {
    
    public static String getInsertEmployee() {
        return "INSERT INTO EmployeeDetails (FirstName, LastName, Email, Age) "
                + "VALUES(?, ?, ?, ?)";
    }
    
    public static String getSearchEmployee() {
        return "SELECT * "
                + "FROM EmployeeDetails " 
                + "WHERE FirstName = ? AND LastName = ?"; 
    }
    
    public static String getShowEmployee() {
        return "SELECT * "
                + "FROM EmployeeDetails "; 
    }
    
    public static String getUpdateEmployee() {
        return "SELECT * FROM EmployeeDetails "
                + "WHERE id = ?";
    }
    
    public static String getUpdateEmployeeDetails() {
        return "UPDATE EmployeeDetails "
                + "SET FirtstName = ? AND LastName = ? AND Email = ? AND Age = ? "
                + "WHERE Id = ?";
    }
}

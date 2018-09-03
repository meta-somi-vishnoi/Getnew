package com.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.models.SearchEmployeeByName;
import com.dao.ConnectionToDatabase;
import com.facade.EmployeeFacade;
import com.models.Employee;
import com.enums.Status;

public class EmployeeDao {
    private static EmployeeDao employeeDao = new EmployeeDao();

    public static EmployeeDao getInstance() {
        return employeeDao;
    }

    public Status addEmployee(Employee employee) {
        try {
            Connection connection = ConnectionToDatabase.getConnection();
            String query = Queries.getInsertEmployee();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setInt(4, employee.getAge());
            int result = statement.executeUpdate();
            if (result > 0) {
                return Status.INSERTED;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Status.NOT_INSERTED;
    }

    public ArrayList<Employee> searchEmployee(SearchEmployeeByName employee) {
        ArrayList<Employee> listOfEmployee = new ArrayList<Employee>();
        try {
            Connection connection = ConnectionToDatabase.getConnection();
            String query = Queries.getSearchEmployee();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                listOfEmployee.add(new Employee(rs.getString("FirstName"), rs.getString("LastName"), 
                        rs.getString("Email"), rs
                        .getInt("Age")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listOfEmployee;
    }

    public ArrayList<Employee> showEmployee() {
        ArrayList<Employee> listOfEmployee = new ArrayList<Employee>();
        try {
            Connection connection = ConnectionToDatabase.getConnection();
            String query = Queries.getShowEmployee();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                listOfEmployee.add(new Employee(rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs
                        .getInt("Age")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listOfEmployee;
    }

    public Employee updateEmployee(int id) {
        Employee employee = null;
        try {
            Connection connection = ConnectionToDatabase.getConnection();
            String query = Queries.getUpdateEmployee();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                employee = new Employee(rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"),
                        rs.getInt("Age"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employee;
    }

    public Status updateEmployeeDetails(Employee employee, int id) {
        try {
            Connection connection = ConnectionToDatabase.getConnection();
            String query = Queries.getUpdateEmployeeDetails();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, id);
            int result = statement.executeUpdate();
            if (result > 0) {
                return Status.UPDATED;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Status.NOT_UPDATED;
    }
}

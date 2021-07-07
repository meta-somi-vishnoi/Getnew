package employeemanagement;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeUsingArrayTest {
    @Test(expected = AssertionError.class)
    public void testAddEmployee() {
        EmployeeUsingArray employeeList = new EmployeeUsingArray();
        employeeList.addEmployee(2, "Somi", "Jaipur");
        employeeList.addEmployee(2, "Jaya", "UP");
    }

    @Test(expected = NullPointerException.class)
    public void testSortOnNameNullPointerException() {
        EmployeeUsingArray employeeList = new EmployeeUsingArray();
        employeeList.addEmployee(2, "Somi", "Jaipur");
        employeeList.addEmployee(4, null, "Punjab");
        employeeList.addEmployee(8, "Ojasvi", "Gujarat");
        employeeList.addEmployee(5, "Mansi", "Harayana");
        employeeList.addEmployee(1, "Jaya", "Jaipur");
        String[] array = new String[] { "Jaya", "Jaya", "Mansi", "Ojasvi", "Somi" };
        ArrayList<Employee> list = employeeList.sortOnBasisOfName();
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i).getName(), array[i]);
        }
    }

    @Test
    public void testSortOnId() {
        EmployeeUsingArray employeeList = new EmployeeUsingArray();
        employeeList.addEmployee(2, "Somi", "Jaipur");
        employeeList.addEmployee(4, "Jaya", "Punjab");
        employeeList.addEmployee(8, "Ojasvi", "Gujarat");
        employeeList.addEmployee(5, "Mansi", "Harayana");
        employeeList.addEmployee(1, "Jaya", "Jaipur");
        int[] array = new int[] { 1, 2, 4, 5, 8 };
        ArrayList<Employee> list = employeeList.sortOnBasisOfId();
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i).getId(), array[i]);
        }
    }

    @Test
    public void testSortOnIdNew() {
        EmployeeUsingArray employeeList = new EmployeeUsingArray();
        employeeList.addEmployee(20, "Shivi", "Udaipur");
        employeeList.addEmployee(2, "Somi", "Jaipur");
        employeeList.addEmployee(11, "Somi", "Mumbai");
        employeeList.addEmployee(4, "Jaya", "Punjab");
        employeeList.addEmployee(8, "Ojasvi", "Gujarat");
        employeeList.addEmployee(5, "Mansi", "Harayana");
        employeeList.addEmployee(1, "Jaya", "Jaipur");
        int[] array = new int[] { 1, 2, 4, 5, 8, 11, 20 };
        ArrayList<Employee> list = employeeList.sortOnBasisOfId();
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i).getId(), array[i]);
        }
    }

    @Test
    public void testSortOnName() {
        EmployeeUsingArray employeeList = new EmployeeUsingArray();
        employeeList.addEmployee(2, "Somi", "Jaipur");
        employeeList.addEmployee(4, "Jaya", "Punjab");
        employeeList.addEmployee(8, "Ojasvi", "Gujarat");
        employeeList.addEmployee(5, "Mansi", "Harayana");
        employeeList.addEmployee(1, "Jaya", "Jaipur");
        String[] array = new String[] { "Jaya", "Jaya", "Mansi", "Ojasvi", "Somi" };
        ArrayList<Employee> list = employeeList.sortOnBasisOfName();
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i).getName(), array[i]);
        }
    }

    @Test
    public void testSortOnNameNew() {
        EmployeeUsingArray employeeList = new EmployeeUsingArray();
        employeeList.addEmployee(20, "Shivi", "Udaipur");
        employeeList.addEmployee(2, "Somi", "Jaipur");
        employeeList.addEmployee(4, "Jaya", "Punjab");
        employeeList.addEmployee(11, "Somi", "Mumbai");
        employeeList.addEmployee(8, "Ojasvi", "Gujarat");
        employeeList.addEmployee(5, "Mansi", "Harayana");
        String[] array = new String[] { "Jaya", "Mansi", "Ojasvi", "Shivi", "Somi", "Somi" };
        ArrayList<Employee> list = employeeList.sortOnBasisOfName();
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i).getName(), array[i]);
        }
    }
}

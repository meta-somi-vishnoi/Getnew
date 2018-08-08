package employee;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class EmployeeUsingMapTest {

    @Test(expected = AssertionError.class)
    public void testAddEmployeeAssertionError() {
        EmployeeUsingMap employeeList = new EmployeeUsingMap();
        assertEquals(true, employeeList.addEmployee(2, "Somi", "Jaipur"));
        assertEquals(true, employeeList.addEmployee(2, "Jaya", "UP"));
    }

    @Test
    public void testAddEmployee() {
        EmployeeUsingMap employeeList = new EmployeeUsingMap();
        assertEquals(true, employeeList.addEmployee(8, "Somi", "Jaipur"));
        assertEquals(true, employeeList.addEmployee(4, "Jaya", "Punjab"));
    }

    @Test
    public void testAddEmployeeAgain() {
        EmployeeUsingMap employeeList = new EmployeeUsingMap();
        assertEquals(true, employeeList.addEmployee(8, "Somi", "Jaipur"));
        assertEquals(true, employeeList.addEmployee(4, "Jaya", "Punjab"));
        assertEquals(true, employeeList.addEmployee(5, "Mansi", "Harayana"));
        assertEquals(true, employeeList.addEmployee(1, "Jaya", "Jaipur"));
    }

    @Test
    public void testSortOnId() {
        EmployeeUsingMap employeeList = new EmployeeUsingMap();
        employeeList.addEmployee(2, "Somi", "Jaipur");
        employeeList.addEmployee(4, "Jaya", "Punjab");
        employeeList.addEmployee(8, "Ojasvi", "Gujarat");
        employeeList.addEmployee(11, "Somi", "Mumbai");
        employeeList.addEmployee(5, "Mansi", "Harayana");
        employeeList.addEmployee(1, "Jaya", "Jaipur");
        int[] array = new int[] { 1, 2, 4, 5, 8, 11 };
        Map<Integer, NewEmployee> mapList = employeeList.sortOnBasisOfId();
        int i = 0;
        for (Map.Entry<Integer, NewEmployee> entry : mapList.entrySet()) {
            assertEquals(entry.getValue().getId(), array[i]);
            i++;
        }
    }

    @Test
    public void testSortOnName() {
        EmployeeUsingMap employeeList = new EmployeeUsingMap();
        employeeList.addEmployee(2, "Somi", "Jaipur");
        employeeList.addEmployee(4, "Jaya", "Punjab");
        employeeList.addEmployee(8, "Ojasvi", "Gujarat");
        employeeList.addEmployee(5, "Mansi", "Harayana");
        employeeList.addEmployee(1, "Jaya", "Jaipur");
        String[] array = new String[] { "Jaya", "Jaya", "Mansi", "Ojasvi", "Somi" };
        Map<Integer, NewEmployee> mapList = employeeList.sortOnBasisOfName();
        int i = 0;
        for (Map.Entry<Integer, NewEmployee> entry : mapList.entrySet()) {
            System.out.println(entry.getValue().getName());
            assertEquals(entry.getValue().getName(), array[i]);
            i++;
        }
    }
}

package employeemanagement;

import java.util.*;

public class EmployeeUsingArray {
    public ArrayList<Employee> listOfEmployee = new ArrayList<Employee>();

    public void addEmployee(int empId, String name, String address) {
        int flag = 0;
        for (int i = 0; i < listOfEmployee.size(); i++) {
            if (listOfEmployee.get(i).getId() == empId) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            listOfEmployee.add(new Employee(empId, name, address));
        } else {
            throw new AssertionError("Employee id already exists");
        }
    }

    public ArrayList<Employee> sortOnBasisOfId() {
        Collections.sort(listOfEmployee, compareId);
        return listOfEmployee;
    }

    public ArrayList<Employee> sortOnBasisOfName() {
        Collections.sort(listOfEmployee, compareName);
        return listOfEmployee;
    }

    Comparator<Employee> compareId = new Comparator<Employee>() {
        public int compare(Employee firstEmployee, Employee secondEmployee) {
            int firstEmployeeId = firstEmployee.getId();
            int secondEmployeeId = secondEmployee.getId();
            return (firstEmployeeId - secondEmployeeId);
        }
    };
    Comparator<Employee> compareName = new Comparator<Employee>() {
        public int compare(Employee firstEmployee, Employee secondEmployee) {
            String firstEmployeeName = firstEmployee.getName();
            String secondEmployeeName = secondEmployee.getName();
            if (secondEmployeeName != null && firstEmployeeName != null) {
                return (firstEmployeeName.compareTo(secondEmployeeName));
            } else {
                throw new NullPointerException("Name is null");
            }
        }
    };
}

package employeemanagement;

import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author vishn_000
 */
class EmployeeUsingMap {
    public Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();

    public boolean addEmployee(int empId, String name, String address) {
        if (employeeMap.containsKey(empId)) {
            throw new AssertionError("Employee id already exists");
        } else {
            Employee person = new Employee(empId, name, address);
            employeeMap.put(empId, person);
            return true;
        }
    }

    public Map<Integer, Employee> sortOnBasisOfId() {
        Set<Entry<Integer, Employee>> set = employeeMap.entrySet();
        List<Entry<Integer, Employee>> list = new ArrayList<Entry<Integer, Employee>>(set);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Employee>>() {
            public int compare(Map.Entry<Integer, Employee> firstEmployee, Map.Entry<Integer, Employee> secondEmployee) {
                return (secondEmployee.getValue().getId()) - (firstEmployee.getValue().getId());
            }
        });
        return employeeMap;
    }

    public Map<Integer, Employee> sortOnBasisOfName() {
        Set<Entry<Integer, Employee>> set = employeeMap.entrySet();
        List<Entry<Integer, Employee>> list = new ArrayList<Entry<Integer, Employee>>(set);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Employee>>() {
            public int compare(Map.Entry<Integer, Employee> firstEmployee, Map.Entry<Integer, Employee> secondEmployee) {
                if(secondEmployee.getValue().getName()!=null && firstEmployee.getValue().getName()!=null) {
                    return (secondEmployee.getValue().getName()).compareTo(firstEmployee.getValue().getName());
                }
                else {
                    throw new NullPointerException("Name is null");
                }
            }
        });
        return employeeMap;
    }
}

package employee;

import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author vishn_000
 */
class EmployeeUsingMap {
    public Map<Integer, NewEmployee> employeeMap = new HashMap<Integer, NewEmployee>();

    public boolean addEmployee(int empId, String name, String address) {
        if (employeeMap.containsKey(empId)) {
            throw new AssertionError("Employee id already exists");
        } else {
            NewEmployee person = new NewEmployee(empId, name, address);
            employeeMap.put(empId, person);
            return true;
        }
    }

    public Map<Integer, NewEmployee> sortOnBasisOfId() {
        Set<Entry<Integer, NewEmployee>> set = employeeMap.entrySet();
        List<Entry<Integer, NewEmployee>> list = new ArrayList<Entry<Integer, NewEmployee>>(set);
        Collections.sort(list, new Comparator<Map.Entry<Integer, NewEmployee>>() {
            public int compare(Map.Entry<Integer, NewEmployee> firstPerson, Map.Entry<Integer, NewEmployee> secondPerson) {
                return (secondPerson.getValue().getId()) - (firstPerson.getValue().getId());
            }
        });
        return employeeMap;
    }

    public Map<Integer, NewEmployee> sortOnBasisOfName() {
        Set<Entry<Integer, NewEmployee>> set = employeeMap.entrySet();
        List<Entry<Integer, NewEmployee>> list = new ArrayList<Entry<Integer, NewEmployee>>(set);
        Collections.sort(list, new Comparator<Map.Entry<Integer, NewEmployee>>() {
            public int compare(Map.Entry<Integer, NewEmployee> firstPerson, Map.Entry<Integer, NewEmployee> secondPerson) {
                return (secondPerson.getValue().getName()).compareTo(firstPerson.getValue().getName());
            }
        });
        return employeeMap;
    }
}

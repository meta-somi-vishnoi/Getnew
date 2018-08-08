package employee;

import java.util.*;

public class EmployeeUsingArray {
    public ArrayList<NewEmployee> listOfEmployee = new ArrayList<NewEmployee>();

    public void addEmployee(int empId, String name, String address) {
        int flag = 0;
        for (int i = 0; i < listOfEmployee.size(); i++) {
            if (listOfEmployee.get(i).getId() == empId) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            NewEmployee person = new NewEmployee(empId, name, address);
            listOfEmployee.add(person);
        } else {
            throw new AssertionError("Employee id already exists");
        }
    }

    public ArrayList<NewEmployee> sortOnBasisOfId() {
        Collections.sort(listOfEmployee, compareId);
        return listOfEmployee;
    }

    public ArrayList<NewEmployee> sortOnBasisOfName() {
        Collections.sort(listOfEmployee, compareName);
        return listOfEmployee;
    }

    Comparator<NewEmployee> compareId = new Comparator<NewEmployee>() {
        public int compare(NewEmployee firstPerson, NewEmployee secondPerson) {
            int firstPersonId = firstPerson.getId();
            int secondPersonId = secondPerson.getId();
            return (int) (firstPersonId - secondPersonId);
        }
    };
    Comparator<NewEmployee> compareName = new Comparator<NewEmployee>() {
        public int compare(NewEmployee firstPerson, NewEmployee secondPerson) {
            String firstPersonName = firstPerson.getName();
            String secondPersonName = secondPerson.getName();
            return (int) (firstPersonName.compareTo(secondPersonName));
        }
    };
}
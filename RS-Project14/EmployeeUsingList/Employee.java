package employeemanagement;

/**
 *
 * @author vishn_000
 */
class Employee {
    private int empId;
    private String name;
    private String address;

    Employee(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

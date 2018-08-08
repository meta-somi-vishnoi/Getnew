package employee;

/**
 *
 * @author vishn_000
 */
class NewEmployee {
    private int empId;
    private String name;
    private String address;

    NewEmployee(int empId, String name, String address) {
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

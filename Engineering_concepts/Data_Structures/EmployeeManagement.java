class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "Emp[" + employeeId + "] " + name + " - " + position + " ($" + salary + ")";
    }
}

public class EmployeeManagement {
    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public boolean add(Employee emp) {
        if (size >= employees.length) {
            System.out.println("Error: System inventory registry array full.");
            return false;
        }

        employees[size++] = emp;
        return true;
    }

    public Employee search(String empId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(empId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean delete(String empId) {
        int targetIndex = -1;

        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(empId)) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex == -1) {
            return false;
        }

        for (int i = targetIndex; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[--size] = null;
        return true;
    }

    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement(5);

        em.add(new Employee("E001", "John Doe", "Manager", 75000));
        em.add(new Employee("E002", "Jane Smith", "Developer", 65000));
        em.add(new Employee("E003", "Bob Johnson", "Designer", 55000));

        System.out.println("Employee Records");
        em.traverse();

        System.out.println("\nSearching for E002:");
        System.out.println(em.search("E002"));

        System.out.println("\nDeleting Record E001...");
        em.delete("E001");

        em.traverse();
    }
}
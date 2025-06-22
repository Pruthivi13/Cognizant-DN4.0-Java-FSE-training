public class EmployeeManager {
    private Employee[] employees;
    private int count;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    // Add employee
    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
            System.out.println("Added: " + emp);
        } else {
            System.out.println("Cannot add more employees. Array is full.");
        }
    }

    // Search by ID
    public Employee searchById(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    // Delete by ID
    public void deleteById(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == id) {
                // Shift elements left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Deleted employee with ID: " + id);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // Traverse and display
    public void displayAll() {
        System.out.println("\nEmployee List:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }
}

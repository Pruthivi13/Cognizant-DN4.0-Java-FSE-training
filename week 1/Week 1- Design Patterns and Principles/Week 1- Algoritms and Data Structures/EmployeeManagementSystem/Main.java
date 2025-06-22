public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        Employee e1 = new Employee(101, "Alice", "Manager", 75000);
        Employee e2 = new Employee(102, "Bob", "Developer", 55000);
        Employee e3 = new Employee(103, "Charlie", "Designer", 50000);

        manager.addEmployee(e1);
        manager.addEmployee(e2);
        manager.addEmployee(e3);

        manager.displayAll();

        Employee found = manager.searchById(102);
        System.out.println("\nSearch Result: " + (found != null ? found : "Not Found"));

        manager.deleteById(101);
        manager.displayAll();
    }
}

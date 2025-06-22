package di;

public class Main {
    public static void main(String[] args) {
        // Manual Dependency Injection
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        // Use the service
        System.out.println("Fetching Customer C101:");
        service.printCustomerDetails("C101");

        System.out.println("\nFetching Customer C999:");
        service.printCustomerDetails("C999");
    }
}

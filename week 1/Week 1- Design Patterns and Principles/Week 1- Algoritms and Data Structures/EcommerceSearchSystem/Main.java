public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Shoes", "Fashion"),
            new Product("P003", "Keyboard", "Electronics"),
            new Product("P004", "Book", "Education"),
            new Product("P005", "Mouse", "Electronics")
        };

        String searchTerm = "Keyboard";

        // Linear Search
        Product result1 = SearchService.linearSearch(products, searchTerm);
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Not Found"));

        // Binary Search
        Product result2 = SearchService.binarySearch(products, searchTerm);
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Not Found"));
    }
}

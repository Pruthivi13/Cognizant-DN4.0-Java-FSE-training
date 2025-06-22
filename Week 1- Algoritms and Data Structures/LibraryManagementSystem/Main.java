public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Hobbit", "J.R.R. Tolkien"),
            new Book(2, "1984", "George Orwell"),
            new Book(3, "To Kill a Mockingbird", "Harper Lee"),
            new Book(4, "Brave New World", "Aldous Huxley"),
            new Book(5, "Fahrenheit 451", "Ray Bradbury")
        };

        System.out.println("Available Books:");
        Library.displayBooks(books);

        String searchTitle = "1984";

        // Linear Search
        Book result1 = Library.linearSearch(books, searchTitle);
        System.out.println("\nLinear Search Result: " + (result1 != null ? result1 : "Not Found"));

        // Binary Search
        Book result2 = Library.binarySearch(books, searchTitle);
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Not Found"));
    }
}

import java.util.Arrays;
import java.util.Comparator;

public class Library {

    // Linear search by title
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // Binary search by title (assumes sorted list)
    public static Book binarySearch(Book[] books, String title) {
        Arrays.sort(books, Comparator.comparing(Book::getTitle)); // Ensure sorted

        int left = 0, right = books.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);

            if (cmp == 0)
                return books[mid];
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return null;
    }

    public static void displayBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

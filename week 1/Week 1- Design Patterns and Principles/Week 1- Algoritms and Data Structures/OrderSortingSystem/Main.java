public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O101", "Alice", 299.99),
            new Order("O102", "Bob", 99.50),
            new Order("O103", "Charlie", 499.00),
            new Order("O104", "Diana", 150.25),
            new Order("O105", "Evan", 199.99)
        };

        System.out.println("Original Orders:");
        SortService.printOrders(orders);

        // Bubble Sort
        Order[] bubbleSorted = orders.clone();
        SortService.bubbleSort(bubbleSorted);
        System.out.println("\nSorted by Bubble Sort:");
        SortService.printOrders(bubbleSorted);

        // Quick Sort
        Order[] quickSorted = orders.clone();
        SortService.quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("\nSorted by Quick Sort:");
        SortService.printOrders(quickSorted);
    }
}

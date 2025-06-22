public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        Product p1 = new Product("P001", "Laptop", 10, 899.99);
        Product p2 = new Product("P002", "Mouse", 50, 19.99);
        Product p3 = new Product("P003", "Keyboard", 30, 49.99);

        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);

        manager.displayInventory();

        manager.updateProduct("P002", "Wireless Mouse", 40, 24.99);
        manager.deleteProduct("P001");

        manager.displayInventory();
    }
}

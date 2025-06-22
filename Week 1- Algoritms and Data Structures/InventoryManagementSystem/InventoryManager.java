import java.util.HashMap;

public class InventoryManager {
    private HashMap<String, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Added: " + product);
    }

    public void updateProduct(String productId, String name, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Updated: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Deleted product with ID: " + productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}

import java.util.HashMap;

public class InventoryManager {
    public HashMap<String, Product> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    // Add a new product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product added successfully!");
    }

    // Update an existing product
    public void updateProduct(String productId, Product newProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, newProduct);
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    // Delete a product
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    // Display all products
    public void displayProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}

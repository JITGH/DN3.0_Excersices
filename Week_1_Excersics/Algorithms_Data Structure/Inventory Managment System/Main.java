import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    String productId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    Product product = new Product(productId, productName, quantity, price);
                    manager.addProduct(product);
                    break;
                case 2:
                    System.out.print("Enter Product ID to update: ");
                    String updateProductId = scanner.nextLine();
                    if (manager.inventory.containsKey(updateProductId)) {
                        System.out.print("Enter new Product Name: ");
                        String newProductName = scanner.nextLine();
                        System.out.print("Enter new Quantity: ");
                        int newQuantity = scanner.nextInt();
                        System.out.print("Enter new Price: ");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline

                        Product newProduct = new Product(updateProductId, newProductName, newQuantity, newPrice);
                        manager.updateProduct(updateProductId, newProduct);
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    String deleteProductId = scanner.nextLine();
                    manager.deleteProduct(deleteProductId);
                    break;
                case 4:
                    manager.displayProducts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

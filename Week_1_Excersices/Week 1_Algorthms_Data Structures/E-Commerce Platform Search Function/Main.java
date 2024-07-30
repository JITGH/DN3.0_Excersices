import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product("101", "Laptop", "Electronics"),
            new Product("102", "Smartphone", "Electronics"),
            new Product("103", "Table", "Furniture"),
            new Product("104", "Chair", "Furniture"),
            new Product("105", "Headphones", "Accessories")
        };

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nE-commerce Platform Search");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter product name to search: ");
            String productName = scanner.nextLine();

            Product foundProduct = null;
            switch (choice) {
                case 1:
                    foundProduct = LinearSearch.linearSearch(products, productName);
                    break;
                case 2:
                    foundProduct = BinarySearch.binarySearch(products, productName);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            if (foundProduct != null) {
                System.out.println("Search Result: " + foundProduct);
            } else {
                System.out.println("Product not found!");
            }
        }

        scanner.close();
    }
}

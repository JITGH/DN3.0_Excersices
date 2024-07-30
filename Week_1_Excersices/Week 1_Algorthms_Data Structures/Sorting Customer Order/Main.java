import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of orders: ");
        int numberOfOrders = scanner.nextInt();
        scanner.nextLine();  

        Order[] orders = new Order[numberOfOrders];

        for (int i = 0; i < numberOfOrders; i++) {
            System.out.println("Enter details for order " + (i + 1));
            System.out.print("Order ID: ");
            String orderId = scanner.nextLine();
            System.out.print("Customer Name: ");
            String customerName = scanner.nextLine();
            System.out.print("Total Price: ");
            double totalPrice = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            orders[i] = new Order(orderId, customerName, totalPrice);
        }

        System.out.println("Choose sorting algorithm: 1 for Bubble Sort, 2 for Quick Sort");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                BubbleSort.sort(orders);
                System.out.println("Orders sorted by Bubble Sort:");
                break;
            case 2:
                QuickSort.sort(orders);
                System.out.println("Orders sorted by Quick Sort:");
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        for (Order order : orders) {
            System.out.println(order.getOrderId() + ": " + order.getTotalPrice());
        }

        scanner.close();
    }
}

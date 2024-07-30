import java.util.Scanner;
public class Main{
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    SinglyLinkedList taskList = new SinglyLinkedList();
    int choice;

    while (true) {
        System.out.println("\nTask Management System Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Search Task");
        System.out.println("3. Traverse Tasks");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice == 1) {
            System.out.print("Enter Task ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  
            System.out.print("Enter Task Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Task Status: ");
            String status = scanner.nextLine();
            taskList.addTask(new Task(id, name, status));
            System.out.println("Task added successfully.");
        } else if (choice == 2) {
            System.out.print("Enter Task ID to search: ");
            int id = scanner.nextInt();
            Task task = taskList.searchTask(id);
            if (task != null) {
                System.out.println("Task Found: " + task);
            } else {
                System.out.println("Task not found.");
            }
        } else if (choice == 3) {
            System.out.println("All Tasks:");
            taskList.traverseTasks();
        } else if (choice == 4) {
            System.out.print("Enter Task ID to delete: ");
            int id = scanner.nextInt();
            if (taskList.deleteTask(id)) {
                System.out.println("Task deleted successfully.");
            } else {
                System.out.println("Task not found.");
            }
        } else if (choice == 5) {
            System.out.println("Exiting...");
            break;
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    scanner.close();
}
}
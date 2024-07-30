import java.util.Scanner;
public class Main{
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the initial capacity for employee records: ");
    int capacity = scanner.nextInt();
    scanner.nextLine();  

    EmployeeManagementSystem ems = new EmployeeManagementSystem(capacity);

    while (true) {
        System.out.println("\nEmployee Management System Menu:");
        System.out.println("1. Add Employee");
        System.out.println("2. Search Employee");
        System.out.println("3. Traverse Employees");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                System.out.print("Enter Employee ID: ");
                String employeeId = scanner.nextLine();
                System.out.print("Enter Employee Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Employee Position: ");
                String position = scanner.nextLine();
                System.out.print("Enter Employee Salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine();  
                ems.addEmployee(new Employee(employeeId, name, position, salary));
                break;
            case 2:
                System.out.print("Enter Employee ID to search: ");
                String searchId = scanner.nextLine();
                Employee emp = ems.searchEmployee(searchId);
                if (emp != null) {
                    System.out.println("Employee Found: " + emp);
                } else {
                    System.out.println("Employee not found.");
                }
                break;
            case 3:
                System.out.println("All Employees:");
                ems.traverseEmployees();
                break;
            case 4:
                System.out.print("Enter Employee ID to delete: ");
                String deleteId = scanner.nextLine();
                if (ems.deleteEmployee(deleteId)) {
                    System.out.println("Employee deleted.");
                } else {
                    System.out.println("Employee not found.");
                }
                break;
            case 5:
                System.out.println("Exiting...");
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
}

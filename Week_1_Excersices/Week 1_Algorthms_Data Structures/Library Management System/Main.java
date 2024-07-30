import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(100); // assuming library can hold 100 books

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title (Linear Search)");
            System.out.println("3. Search Book by Title (Binary Search)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter Book ID: ");
                String id = scanner.nextLine();
                
                System.out.print("Enter Book Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Book Author: ");
                String author = scanner.nextLine();
                library.addBook(new Book(id, title, author));
                System.out.println("Book added successfully.");
                library.sortBooksByTitle(); // ensure books are sorted after adding
            } else if (choice == 2) {
                System.out.print("Enter Book Title to search: ");
                String title = scanner.nextLine();
                Book book = LinearSearch.searchByTitle(library.getBooks(), title);
                if (book != null) {
                    System.out.println("Book Found: " + book);
                } else {
                    System.out.println("Book not found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter Book Title to search: ");
                String title = scanner.nextLine();
                Book book = BinarySearch.searchByTitle(library.getBooks(), title);
                if (book != null) {
                    System.out.println("Book Found: " + book);
                } else {
                    System.out.println("Book not found.");
                }
            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

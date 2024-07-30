import java.util.Arrays;

public class Library {
    private Book[] books;
    private int count;

    public Library(int size) {
        books = new Book[size];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
        } else {
            System.out.println("Library is full, cannot add more books.");
        }
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, count);
    }

    public void sortBooksByTitle() {
        Arrays.sort(books, 0, count, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
    }
}

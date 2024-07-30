public class Book {
  private String bookId;
  private String title;
  private String author;


    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return this.bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "{" +"\n"+
            "bookId= " + getBookId() + "\n" +
            "title= " + getTitle() + "\n" +
            "author= " + getAuthor() + "\n" +
            "}";
    }

}

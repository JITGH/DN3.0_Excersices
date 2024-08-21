package com.book.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.repository.BookRepository;

@Service

public class BookService {
	@Autowired
	BookRepository bookRepository;

	private final List<Book> books = List.of(
	        new Book(1,"java-Spring", "Text", 1950.00, "isbn-123498289"),
	        new Book(2,"Advance Java", "Test", 4450.23, "isbn-89563076")
	    );
    public List<Book> getAllBooks() {
        // Logic to fetch all books
        return List.of(
            new Book(1,"Spring", "Java", 6039.23, "ISBN123456"),
            new Book(2,"STL", "C++", 5930.12, "ISBN789632")
        );
    }
    public List<Book> getBooks()
    {
    	return bookRepository.findAll();
    }
    public Book getBookId(int id)
    {
    	return bookRepository.findById(id).get();
    }
    public Book getBookById(int id) {
        return books.stream()
            .filter(book -> book.getId()==id)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<Book> filterBooks(String title, String author) {
        return books.stream()
            .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                            (author == null || book.getAuthor().equalsIgnoreCase(author)))
            .collect(Collectors.toList());
    }
    public List<Book> filterBooks1(String title, String author) {
    	List<Book> book1s= bookRepository.findAll();
        return book1s.stream()
            .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                            (author == null || book.getAuthor().equalsIgnoreCase(author)))
            .collect(Collectors.toList());
    }
    public Book addBook(Book book)
    {
    	return bookRepository.save(book);
    }
    public Book updateBook(int bookid,Book book)
    {
    	Book oldbook= bookRepository.findById(bookid).get();
    	if(oldbook==null)
    	{
    		return null;
    	}
    	
    	oldbook.setAuthor(book.getAuthor());
    	oldbook.setIsbn(book.getIsbn());
    	oldbook.setPrice(book.getPrice());
    	oldbook.setTitle(book.getTitle());
    	return bookRepository.save(oldbook);
    }
    public String deleteBook(int id)
    {
    	Book book= bookRepository.findById(id).get();
    	if(book==null)
    	{
    		return "Book Id"+id+" not found";
    	}
    	bookRepository.delete(book);
    	return "Book Id"+id+" is deleted successfully";
    }
}

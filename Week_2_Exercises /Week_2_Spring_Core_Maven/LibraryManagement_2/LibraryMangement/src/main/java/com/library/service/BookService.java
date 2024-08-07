package com.library.service;
import com.library.repository.BookRepository;
public class BookService {
private BookRepository bookRepository;

public void setBookRepository(BookRepository bookRepository) {
	this.bookRepository = bookRepository;
}

public void getadd() {
	System.out.println("Book is added !");
	bookRepository.save();
}
}

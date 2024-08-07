package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	      BookService bookService = (BookService) context.getBean("bookService");
	      
	      bookService.getadd();

	}

}

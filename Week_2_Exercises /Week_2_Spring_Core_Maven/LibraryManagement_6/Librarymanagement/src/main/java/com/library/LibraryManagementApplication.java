package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.bookservice.BookService;

public class LibraryManagementApplication {
	 public static void main( String[] args )
	    {
	       
	    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	        BookService bookService = context.getBean(BookService.class);
	        
	        System.out.print("Bean Annotation works");
	    }
}

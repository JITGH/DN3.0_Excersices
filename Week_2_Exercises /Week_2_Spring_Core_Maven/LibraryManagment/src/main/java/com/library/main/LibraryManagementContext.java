package com.library.main;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class LibraryManagementContext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	        BookService bookService = (BookService) context.getBean("bookService");
	        bookService.addBook();
	        System.out.println("Logging aspect is working. Check the console for method execution times.");
	    
	}

}

package org.library;

import org.library.repository.BookRepository;
import org.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//create bean of BookService
		BookService bookService = (BookService) context.getBean("bookService");
		//call getadd method
		bookService.getadd();
		//create bean of BookRepository
		BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
		//call getsave method
		bookRepository.getsave();
		
	}

}

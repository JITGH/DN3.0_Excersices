package com.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String title;
    private String author;
    private String isbn;

	public Book() {
		this.id=0;
		this.title=null;
		this.author=null;
		this.isbn=null;
	}

	public Book( String title, String author, String isbn) {
		super();
		
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}

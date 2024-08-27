package com.code.api.controllers;

import java.util.List;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.code.api.dto.BookDTO;
import com.code.api.entity.Book;
import com.code.api.services.BookService;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book Management", description = "Operations related to managing books in the bookstore")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Test API", description = "Test if the API is working")
    @GetMapping("/test")
    public String test() {
        return "welcome";
    }

    @Operation(summary = "Filter books", description = "Filter books by title and/or author")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully retrieved books"),
        @ApiResponse(responseCode = "400", description = "Invalid input provided")
    })
    @GetMapping("/search")
    public List<Book> filterBooks(@RequestParam(required = false) String title, 
                                  @RequestParam(required = false) String author) {
        return bookService.filterBooks(title, author);
    }

    @Operation(summary = "Get all books", description = "Retrieve a list of all books in the bookstore")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully retrieved list of books"),
        @ApiResponse(responseCode = "204", description = "No books found")
    })
    @GetMapping("/")
    public ResponseEntity<List<BookDTO>> getBooks() {
        List<BookDTO> books = bookService.getBooks();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @Operation(summary = "Get all books with HATEOAS links", description = "Retrieve all books with additional HATEOAS links")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully retrieved list of books with HATEOAS links"),
        @ApiResponse(responseCode = "204", description = "No books found")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getBooks();
        for (BookDTO bookDTO : books) {
            // Add self link
            bookDTO.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(bookDTO.getId())).withSelfRel());

            // Add link to all books
            bookDTO.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("all-books"));
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @Operation(summary = "Add a new book", description = "Create a new book in the bookstore")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Book successfully created", content = @Content(schema = @Schema(implementation = Book.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping(value = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.CREATED)
    public HttpEntity<Book> addBook(@Valid @RequestBody Book book) {
        // Adding custom headers to the response
        HttpHeaders headers = new HttpHeaders();
        headers.add("MYBOOKSTORE-APP", "Bookstore API");
        headers.add("RESPONSE-TIME", String.valueOf(System.currentTimeMillis()));
        book = bookService.addBook(book);
        return new ResponseEntity<>(book, headers, HttpStatus.OK);
    }

    @Operation(summary = "Update a book", description = "Edit an existing book by its ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Book successfully updated", content = @Content(schema = @Schema(implementation = Book.class))),
        @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @Operation(summary = "Get a book by ID", description = "Fetch a specific book by its ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Book found", content = @Content(schema = @Schema(implementation = Book.class))),
        @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return new ResponseEntity<>(bookService.getBookId(id), HttpStatus.OK);
    }

    @Operation(summary = "Delete a book", description = "Remove a book from the bookstore by its ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Book successfully deleted"),
        @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

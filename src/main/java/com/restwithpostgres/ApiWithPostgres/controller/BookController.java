package com.restwithpostgres.ApiWithPostgres.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restwithpostgres.ApiWithPostgres.model.Book;
import com.restwithpostgres.ApiWithPostgres.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	// Getting all books
	@GetMapping("/books")
	public List<Book> getAllBooks()
	{
		return bookRepository.findAllBooks();
	}
	
	// Insert a book
	@PostMapping("/books")
	public int createBook(@Valid @RequestBody Book book)
	{
		return bookRepository.insertBook(book);
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable int id)
	{
		return bookRepository.getBookById(id);
	}
	
	@DeleteMapping("/books/{id}")
	public int deleteBookById(@PathVariable int id)
	{
		return bookRepository.deleteBook(id);
	}
	
	@PutMapping("/books/{id}")
	public int updateBook(@Valid @RequestBody Book book, @PathVariable int id)
	{
		System.out.println("ID : "+id);
		return bookRepository.updateBook(book, id);
	}

}

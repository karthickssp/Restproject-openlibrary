package com.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Book;
import com.service.BookService;

@RestController

public class BookController {
	
	@Autowired
	BookService bookservice;

	@GetMapping("/get")  
	
	public List<Book> GetAllBooks()   
	{  
		return bookservice.getAllBooks();  
	}  

	@GetMapping("/get/{bookno}") 
	
	public Book GetBooks(@PathVariable("bookno") int bookno)   
	{  
		return bookservice.getBooks(bookno); 
	}  

	@DeleteMapping("/delete/{bookno}")  
	
	public void DeleteBook(@PathVariable("bookno") int bookno)   
	{  
		bookservice.deleteBook(bookno);  
	}  

	@PostMapping("/post")  
	
	public Book SaveBook(@RequestBody Book books)   
	{  
		return bookservice.saveBook(books);  
	}  
	
	@PutMapping("/put")  
	
	public Book Update(@RequestBody Book books)   
	{  
		bookservice.update(books);  
		return books;  
	} 
	
}

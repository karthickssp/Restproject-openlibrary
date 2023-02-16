package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Book;
import com.dao.BookRepository;
@Service
public class BookService {
	
	@Autowired
	BookRepository booksRepository;  
	
	public List<Book> getAllBooks()   
	{  
		return (List<Book>) booksRepository.findAll();  
	}  
	
	public Book getBooks(@PathVariable("bookno") int bookno)   
	{  
		return booksRepository.findById(bookno).get(); 
	}  
	
	public void deleteBook(@PathVariable("bookno") int bookno)   
	{  
		booksRepository.deleteById(bookno);  
	}  
	
	public Book saveBook(@RequestBody Book books)   
	{  
		return booksRepository.save(books);  
	}
	
	public Book update(@RequestBody Book books)   
	{  
		booksRepository.save(books);  
		return books;  
	}  
	
	

}
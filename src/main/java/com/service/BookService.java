package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.model.Book;
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
	
	public Iterable<Book> BookAscendingsort(String feild)
	{
		return booksRepository.findAll(Sort.by(feild));
	}
	
	public Iterable<Book> BookDescendingsort(String feild)
	{
		return booksRepository.findAll(Sort.by(Direction.DESC,feild));
	}
	
	public Page<Book> Bookpage(int pageno,int pagesize) 
	{
		Pageable paging = PageRequest.of(pageno, pagesize);
		return booksRepository.findAll(paging);
	}
	
	public Page<Book> Bookpagesort(int pageno,int pageSize,String feild) 
	{
		Pageable paging = PageRequest.of(pageno, pageSize).withSort(Sort.by(feild));
		return booksRepository.findAll(paging);
	}
	
	public List<Book> AuthorBook(String author)   
	{  
		return (List<Book>) booksRepository.findByAuthor( author);  
	}  
	
	public List<Book> StartBook(String letter)   
	{  
		return (List<Book>) booksRepository.findBybooknameStartingWith(letter);
	}  
	
	public List<Book> RankingBook(double rank)   
	{  
		return (List<Book>) booksRepository.findByratingGreaterThan(rank);
	}  
}
package com.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Book;
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
	
	
	
	//sorting
	@GetMapping("/asort/{feild}")
	public Iterable<Book> getBookSort(@PathVariable("feild") String feild)
	{
		return bookservice.BookAscendingsort(feild);
	}
	
	@GetMapping("/dsort/{feild}")
	public Iterable<Book> getDesBookSort(@PathVariable("feild") String feild)
	{
		return bookservice.BookDescendingsort(feild);
	}
	
	//paging
	@GetMapping("/page/{pageno}/{pagesize}")
	public Page <Book> getBookPage(@PathVariable("pageno") int pageno,@PathVariable("pagesize") int pagesize)
	{
		return bookservice.Bookpage(pageno,pagesize);
	} 
	
	//page and sort
	@GetMapping("/pagesort/{pageno}/{pagesize}/{feild}")
	public Page<Book> BookPageSort(@PathVariable ("pageno") int pageno,@PathVariable ("pagesize") int pagesize,@PathVariable ("feild")String feild)
	{
		return bookservice.Bookpagesort(pageno, pagesize,feild);
	}
	
	//books by author
	@GetMapping("/byauthor/{author}")
	public Iterable<Book> getAuthorBook(@PathVariable("author") String author)
	{
		return bookservice.AuthorBook(author);
	}
	
	@GetMapping("/start/{letter}")
	public Iterable<Book> getStartBook(@PathVariable("letter") String letter)
	{
		return bookservice.StartBook(letter);
	}
	
	@GetMapping("/rank/{rank}")
	public Iterable<Book> getRankBook(@PathVariable("rank") double rank)
	{
		return bookservice.RankingBook(rank);
	}

}
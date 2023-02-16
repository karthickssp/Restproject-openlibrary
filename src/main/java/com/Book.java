package com;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bookdetails")

public class Book {
	
	@Id
	@Column
	private int bookno;
	@Column
	private String bookname;
	@Column
	private String author;
	@Column
	private double rating;
	@Column
	private long page;
	
	public Book()
	{
		
	}

	public Book(int bookno, String bookname, String author, double rating, long page) {
		super();
		this.bookno = bookno;
		this.bookname = bookname;
		this.author = author;
		this.rating = rating;
		this.page = page;
	}

	public int getBookno() {
		return bookno;
	}

	public void setBookno(int bookno) {
		this.bookno = bookno;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "Book [bookno=" + bookno + ", bookname=" + bookname + ", author=" + author + ", rating=" + rating
				+ ", page=" + page + "]";
	}
	
}

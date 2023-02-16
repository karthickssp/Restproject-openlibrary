package com.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{

	@Override
	List<Book>findAll();	
}
package com.johnson.spring6webapp.service;

import com.johnson.spring6webapp.domain.Book;
import com.johnson.spring6webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll(){
        return null;
    }


}

package com.johnson.spring6webapp.service;

import com.johnson.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}

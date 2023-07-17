package com.johnson.spring6webapp.controllers;

import com.johnson.spring6webapp.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Model is an interface that defines a holder for model attributes and is primarily designed for adding attributes to the model.
    @RequestMapping("/books") // Spring MVC will call this method when the /books URL is requested.
    public String getBooks(Model model){
        model.addAttribute("books", bookService.findAll());
        return "books";// view name
    }
}

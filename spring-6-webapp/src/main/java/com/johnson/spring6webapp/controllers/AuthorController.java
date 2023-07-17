package com.johnson.spring6webapp.controllers;

import com.johnson.spring6webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Model is an interface that defines a holder for model attributes and is primarily designed for adding attributes to the model.
    @RequestMapping("/authors") // Spring MVC will call this method when the /authors URL is requested.
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";// view name
    }
}

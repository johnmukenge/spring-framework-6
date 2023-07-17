package com.johnson.spring6webapp.bootstrap;

import com.johnson.spring6webapp.domain.Author;
import com.johnson.spring6webapp.domain.Book;
import com.johnson.spring6webapp.repositories.AuthorRepository;
import com.johnson.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Component is a Spring annotation that marks a java class as a bean so the component-scanning mechanism of Spring can add it into the application context.
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    // Constructor
    //
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Johnson");
        Author rod = new Author("Rod", "Johnson");
        Book ddd = new Book("Domain Driven Design", "123123");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");

        Author ericSaved = authorRepository.save(eric);
        Author rodSaved = authorRepository.save(rod);
        Book dddSaved = bookRepository.save(ddd);
        Book noEJBSaved = bookRepository.save(noEJB);

        // Building the relationships between the Author and Book objects
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        // Saving the relationships between the Author and Book objects
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
    }
}

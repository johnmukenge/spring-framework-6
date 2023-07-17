package com.johnson.spring6webapp.bootstrap;

import com.johnson.spring6webapp.domain.Author;
import com.johnson.spring6webapp.domain.Book;
import com.johnson.spring6webapp.domain.Publisher;
import com.johnson.spring6webapp.repositories.AuthorRepository;
import com.johnson.spring6webapp.repositories.BookRepository;
import com.johnson.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Component is a Spring annotation that marks a java class as a bean so the component-scanning mechanism of Spring can add it into the application context.
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    // Constructor
    //
    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Johnson");
        Author rod = new Author("Rod", "Johnson");

        Book ddd = new Book("Domain Driven Design", "123123");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");

        Publisher publisher = new Publisher();
        publisher.setPublisherName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        Author ericSaved = authorRepository.save(eric);
        Author rodSaved = authorRepository.save(rod);

        Book dddSaved = bookRepository.save(ddd);
        Book noEJBSaved = bookRepository.save(noEJB);

        Publisher savedPublisher = publisherRepository.save(publisher);

        dddSaved.setPublisher(savedPublisher);
        noEJBSaved.setPublisher(savedPublisher);

        // Building the relationships between the Author and Book objects
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        // Saving the relationships between the Author and Book objects
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}

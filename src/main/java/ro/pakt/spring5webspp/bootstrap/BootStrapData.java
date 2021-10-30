package ro.pakt.spring5webspp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ro.pakt.spring5webspp.domain.Author;
import ro.pakt.spring5webspp.domain.Book;
import ro.pakt.spring5webspp.repositories.AuthorRepository;
import ro.pakt.spring5webspp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("Eric", "Evans");
        Book book = new Book("Domain Drive Design", "123132");
        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);

        Author unnamed = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "321321");
        unnamed.getBooks().add(noEJB);
        noEJB.getAuthors().add(unnamed);

        authorRepository.save(unnamed);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books " + bookRepository.count());

    }

}

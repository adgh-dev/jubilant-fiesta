package ro.pakt.spring5webspp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ro.pakt.spring5webspp.domain.Author;
import ro.pakt.spring5webspp.domain.Book;
import ro.pakt.spring5webspp.domain.Publisher;
import ro.pakt.spring5webspp.repositories.AuthorRepository;
import ro.pakt.spring5webspp.repositories.BookRepository;
import ro.pakt.spring5webspp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
                        BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author author = new Author("Eric", "Evans");
        Book book = new Book("Domain Drive Design", "123132");
        author.getBooks().add(book);
        book.getAuthors().add(author);

        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author unnamed = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "321321");
        unnamed.getBooks().add(noEJB);
        noEJB.getAuthors().add(unnamed);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(unnamed);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }

}

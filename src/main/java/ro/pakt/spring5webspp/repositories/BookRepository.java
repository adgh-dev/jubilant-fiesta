package ro.pakt.spring5webspp.repositories;

import ro.pakt.spring5webspp.domain.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}

package ro.pakt.spring5webspp.repositories;

import ro.pakt.spring5webspp.domain.Author;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}

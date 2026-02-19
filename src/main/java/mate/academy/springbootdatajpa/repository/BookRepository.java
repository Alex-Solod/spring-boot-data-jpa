package mate.academy.springbootdatajpa.repository;

import mate.academy.springbootdatajpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

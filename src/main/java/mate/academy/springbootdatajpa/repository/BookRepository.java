package mate.academy.springbootdatajpa.repository;

import mate.academy.springbootdatajpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIdAndDeletedFalse(Long id);
    List<Book> findAllByDeletedFalse();
}

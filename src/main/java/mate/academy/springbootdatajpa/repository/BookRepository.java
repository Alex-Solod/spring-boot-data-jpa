package mate.academy.springbootdatajpa.repository;

import mate.academy.springbootdatajpa.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIdAndDeletedFalse(Long id);
    Page<Book> findAllByDeletedFalse(Pageable pageable);
}

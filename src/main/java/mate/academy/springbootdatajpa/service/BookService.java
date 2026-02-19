package mate.academy.springbootdatajpa.service;

import mate.academy.springbootdatajpa.dto.BookDto;
import mate.academy.springbootdatajpa.dto.CreateBookRequestDto;
import mate.academy.springbootdatajpa.dto.UpdateBookRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface BookService {
    Page<BookDto> getAllBooks(Pageable pageable);

    BookDto getBookById(Long id);

    BookDto save(CreateBookRequestDto requestDto);

    BookDto updateBook(Long id, UpdateBookRequestDto book);

    void deleteBook(Long id);
}

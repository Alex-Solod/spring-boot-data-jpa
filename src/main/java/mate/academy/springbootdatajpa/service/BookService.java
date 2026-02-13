package mate.academy.springbootdatajpa.service;

import mate.academy.springbootdatajpa.dto.BookDto;
import mate.academy.springbootdatajpa.dto.CreateBookRequestDto;
import mate.academy.springbootdatajpa.dto.UpdateBookRequestDto;
import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks();

    BookDto getBookById(Long id);

    BookDto save(CreateBookRequestDto requestDto);

    BookDto updateBook(Long id, UpdateBookRequestDto book);

    void deleteBook(Long id);
}

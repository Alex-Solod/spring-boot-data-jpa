package mate.academy.springbootdatajpa.service;

import lombok.RequiredArgsConstructor;
import mate.academy.springbootdatajpa.dto.BookDto;
import mate.academy.springbootdatajpa.dto.CreateBookRequestDto;
import mate.academy.springbootdatajpa.dto.UpdateBookRequestDto;
import mate.academy.springbootdatajpa.exception.EntityNotFoundException;
import mate.academy.springbootdatajpa.mapper.BookMapper;
import mate.academy.springbootdatajpa.model.Book;
import mate.academy.springbootdatajpa.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        bookRepository.save(book);
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAllByDeletedFalse()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Book with id " + id + " not found"));
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto updateBook(Long id, UpdateBookRequestDto bookRequestDto) {
        Book book = bookRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Book with id " + id + " not found"));
        bookMapper.updateBookFromDto(bookRequestDto, book);

        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException(
                    "Book with id " + id + " not found");
        }
        bookRepository.deleteById(id);
    }
}

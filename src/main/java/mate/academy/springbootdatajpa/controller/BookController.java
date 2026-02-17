package mate.academy.springbootdatajpa.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mate.academy.springbootdatajpa.dto.BookDto;
import mate.academy.springbootdatajpa.dto.CreateBookRequestDto;
import mate.academy.springbootdatajpa.dto.UpdateBookRequestDto;
import mate.academy.springbootdatajpa.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookDto getById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public BookDto save(@RequestBody @Valid CreateBookRequestDto requestDto) {
        return bookService.save(requestDto);
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id,
            @RequestBody @Valid UpdateBookRequestDto bookDto) {
        return bookService.updateBook(id, bookDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}

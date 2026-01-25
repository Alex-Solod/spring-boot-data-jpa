package mate.academy.springbootdatajpa.mapper;

import mate.academy.springbootdatajpa.dto.BookDto;
import mate.academy.springbootdatajpa.dto.CreateBookRequestDto;
import mate.academy.springbootdatajpa.dto.UpdateBookRequestDto;
import mate.academy.springbootdatajpa.model.Book;
import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto requestDto);

    void updateBookFromDto(UpdateBookRequestDto dto, @MappingTarget Book book);
}

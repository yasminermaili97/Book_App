package com.book_app.book_app1.mapper;

import com.book_app.book_app1.dto.BookDTO;
import com.book_app.book_app1.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO bookToBookDTO(BookEntity book);
    BookEntity bookDTOToBookEntity(BookDTO bookDTO);
    List<BookDTO> bookListToBookDTOList(List<BookEntity> bookList);
}

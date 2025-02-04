package com.book_app.book_app1.service;

import com.book_app.book_app1.dto.BookDTO;
import com.book_app.book_app1.enums.Status;
import java.util.List;

public interface IBookAppService {
    List<BookDTO> getBooks(Status status);
    BookDTO getBook(int id);
    BookDTO createBook(BookDTO bookDTO);
    boolean deleteBook(int id);
}

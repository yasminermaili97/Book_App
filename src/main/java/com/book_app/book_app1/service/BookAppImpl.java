package com.book_app.book_app1.service;

import com.book_app.book_app1.dto.BookDTO;
import com.book_app.book_app1.entity.BookEntity;
import com.book_app.book_app1.enums.Status;
import com.book_app.book_app1.exception.NotFoundException;
import com.book_app.book_app1.mapper.BookMapper;
import com.book_app.book_app1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookAppImpl implements IBookAppService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public BookAppImpl(BookMapper bookMapper, BookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getBooks(Status status) {
        List<BookEntity> bookEntityList = bookRepository.findByStatus(status);
        return bookMapper.bookListToBookDTOList(bookEntityList);
    }

    @Override
    public BookDTO getBook(int id) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un libro con el id " + id));
        return bookMapper.bookToBookDTO(bookEntity);
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        BookEntity bookEntity = bookMapper.bookDTOToBookEntity(bookDTO);
        BookEntity savedBook = bookRepository.save(bookEntity);
        return bookMapper.bookToBookDTO(savedBook);
    }

    @Override
    public boolean deleteBook(int id) {
        if (!bookRepository.existsById(id)) {
            throw new NotFoundException("No existe un libro con el id " + id);
        }
        bookRepository.deleteById(id);
        return true;
    }


}

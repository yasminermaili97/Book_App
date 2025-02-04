package com.book_app.book_app1.controller;

import com.book_app.book_app1.dto.BookDTO;
import com.book_app.book_app1.enums.Status;
import com.book_app.book_app1.service.IBookAppService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final IBookAppService bookAppService;

    public BookController(IBookAppService bookAppService) {
        this.bookAppService = bookAppService;
    }

    @GetMapping("/all/{status}")
    public ResponseEntity<List<BookDTO>> getAllBooks(@PathVariable Status status) {
        return ResponseEntity.ok(bookAppService.getBooks(status));
    }

    @PostMapping("/create")
    public ResponseEntity<BookDTO> createBook(@RequestBody @Valid BookDTO bookDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookAppService.createBook(bookDTO));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable int id) {
        return ResponseEntity.ok(bookAppService.getBook(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable int id) {
        bookAppService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}

package com.book_app.book_app1.repository;

import com.book_app.book_app1.dto.BookDTO;
import com.book_app.book_app1.entity.BookEntity;
import com.book_app.book_app1.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    List<BookEntity> findByStatus(Status status);
    @Modifying
    boolean deleteByid(int id);
    @Override
    Optional<BookEntity> findById(Integer integer);

    @Query("SELECT b FROM BookEntity b WHERE b.isbn LIKE :isbn")
    List<BookEntity> findByISBNLike(@Param("isbn") String isbn);

    @Query("UPDATE BookEntity b set b.price= :price where b.id= :id")
    BookEntity updateBookPrice(int id, double price);

}

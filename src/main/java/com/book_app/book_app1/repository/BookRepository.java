package com.book_app.book_app1.repository;

import com.book_app.book_app1.entity.BookEntity;
import com.book_app.book_app1.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    List<BookEntity> findByStatus(Status status);
    void deleteByid(int id);

    @Override
    Optional<BookEntity> findById(Integer integer);
}

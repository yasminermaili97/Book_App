package com.book_app.book_app1.entity;

import com.book_app.book_app1.enums.Status;
import com.book_app.book_app1.enums.Types;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Types type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "published", nullable = false)
    private LocalDate published;


}

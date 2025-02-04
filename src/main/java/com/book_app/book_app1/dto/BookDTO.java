package com.book_app.book_app1.dto;

import com.book_app.book_app1.enums.Status;
import com.book_app.book_app1.enums.Types;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {

    private int id;

    @NotEmpty(message = "El ISBN no puede estar vacío")
    private String isbn;

    @NotNull(message = "El tipo no puede ser nulo")
    private Types type;

    @NotNull(message = "El estado no puede ser nulo")
    private Status status;

    @Min(value = 1, message = "El precio debe ser un número positivo")
    private double price;

    @NotNull(message = "La fecha de publicación no puede estar vacía")
    private LocalDate published;
}

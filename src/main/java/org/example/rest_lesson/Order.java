package org.example.rest_lesson;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
@Schema(description = "Модель заказа в системе")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "номер заказа", example = "2")
    private int number;

    @Schema(description = "цена", example = "100.5")
    private double price;

    @Schema(description = "Фамилия Имя Отчетсво пользователя", example = "Атаев Абдулатип Болатович")
    private String fio;

    @Schema(description = "Дата изготовние продукта")
    private LocalDateTime createAt;
}

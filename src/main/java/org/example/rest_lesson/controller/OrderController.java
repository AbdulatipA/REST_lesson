package org.example.rest_lesson.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.rest_lesson.Order;
import org.example.rest_lesson.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Заказы", description = "CRUD операции над заказами")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    @Operation(summary = "Добавить заказ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Заказ принят и возвращен обратно")
    })
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @GetMapping("/findById/{id}")
    @Operation(summary = "Найти заказ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Заказ найден по id и возвращен обрано")
    })
    public Order findById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @GetMapping("findByAll")
    @Operation(summary = "Найти все заказы")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Все заказы найдены и возвращены обратно")
    })
    public List<Order> findAll() {
        return orderService.findAll();
    }


    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удалить заказ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Заказ удален по id")
    })
    public void delete(@PathVariable Long id){
        orderService.delete(id);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Обновить заказ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Заказ обновлен по id и возвращен обратно")
    })
    public Order update(@PathVariable Long id, @RequestBody Order order) {
        return orderService.update(id, order);
    }
}

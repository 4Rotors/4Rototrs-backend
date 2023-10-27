package com.example.dronecourier.controller;

import com.example.dronecourier.entity.dto.OrderDto;
import com.example.dronecourier.entity.model.Order;
import com.example.dronecourier.entity.model.OrderItem;
import com.example.dronecourier.entity.model.enums.OrderStatus;
import com.example.dronecourier.service.OrderItemService;
import com.example.dronecourier.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OderController {
    private final OrderService orderService;
    private final OrderItemService orderItemService;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> addOrder(@RequestBody OrderDto dto) {
        Order order = translateToEntity(dto);
        order.setId(orderService.save(order));
        List<OrderItem> items = dto.getItems().stream().map(itemDto -> translateToEntity(itemDto, order)).toList();
        for(OrderItem item : items){
            orderItemService.save(item);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<Order> getAll(){
        return orderService.getAll();
    }

    private OrderDto translateToDto(Order order) {
        OrderDto dto = new OrderDto();

        return dto;
    }

    private Order translateToEntity(OrderDto dto) {
        Order order = new Order();

        order.setArrivalDate(dto.getArrivalDate());
        order.setStatus(OrderStatus.GOING);
        order.setDeliveryAddress(dto.getDeliveryAddress());

        return order;
    }

    private OrderItem translateToEntity(OrderItem dto, Order order) {
        OrderItem orderItem = new OrderItem();

        orderItem.setName(dto.getName());
        orderItem.setCount(dto.getCount());
        orderItem.setPrice(dto.getPrice());
        orderItem.setWeight(dto.getWeight());
        orderItem.setOrder(order);

        return orderItem;
    }

}

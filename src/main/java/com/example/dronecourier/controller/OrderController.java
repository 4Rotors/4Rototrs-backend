package com.example.dronecourier.controller;

import com.example.dronecourier.entity.dto.OrderItemDto;
import com.example.dronecourier.entity.dto.order.OrderDto;
import com.example.dronecourier.entity.dto.order.OrderDtoResponse;
import com.example.dronecourier.entity.model.Order;
import com.example.dronecourier.entity.model.OrderItem;
import com.example.dronecourier.entity.model.enums.OrderStatus;
import com.example.dronecourier.service.OrderItemService;
import com.example.dronecourier.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {
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
    public List<OrderDtoResponse> getAll(){
        List<Order> orders = orderService.getAll();
        List<OrderDtoResponse> result = new ArrayList<>();
        for(Order order : orders){
            OrderDtoResponse orderDtoResponse = new OrderDtoResponse();

            orderDtoResponse.setId(order.getId());
            orderDtoResponse.setDeliveryAddress(order.getDeliveryAddress());
            orderDtoResponse.setArrivalDate(order.getArrivalDate());
            orderDtoResponse.setStatus(order.getStatus().getName());
            orderDtoResponse.setItems(orderItemService.getItemsByOrder(order).stream().map(this::translateToDto).toList());

            result.add(orderDtoResponse);
        }
        return result;
    }


    private Order translateToEntity(OrderDto dto) {
        Order order = new Order();

        order.setArrivalDate(dto.getArrivalDate());
        order.setStatus(OrderStatus.GOING);
        order.setDeliveryAddress(dto.getDeliveryAddress());

        return order;
    }

    private OrderItem translateToEntity(OrderItemDto dto, Order order) {
        OrderItem orderItem = new OrderItem();

        orderItem.setName(dto.getName());
        orderItem.setCount(dto.getCount());
        orderItem.setPrice(dto.getPrice());
        orderItem.setWeight(dto.getWeight());
        orderItem.setOrder(order);

        return orderItem;
    }

    private OrderDtoResponse translateToDto(Order order){
        OrderDtoResponse orderDtoResponse = new OrderDtoResponse();

        orderDtoResponse.setStatus(order.getStatus().getName());
        orderDtoResponse.setArrivalDate(order.getArrivalDate());
        orderDtoResponse.setId(order.getId());

        return orderDtoResponse;

    }

    public OrderItemDto translateToDto(OrderItem item){
        OrderItemDto itemDto = new OrderItemDto();

        itemDto.setName(item.getName());
        itemDto.setPrice(item.getPrice());
        itemDto.setCount(item.getCount());
        itemDto.setWeight(item.getWeight());

        return itemDto;
    }

}

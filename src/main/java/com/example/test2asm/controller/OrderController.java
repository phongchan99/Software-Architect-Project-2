package com.example.test2asm.controller;

import com.example.test2asm.entity.OrderDetail;
import com.example.test2asm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("/placeOrder")
    public OrderDetail addOrder(@RequestBody OrderDetail orderDetail) {
        return service.saveOrder(orderDetail);
    }

    @PostMapping("/placeOrders")
    public List<OrderDetail> addOrders(@RequestBody List<OrderDetail> orderDetails) {
        return service.saveOrders(orderDetails);
    }

    @GetMapping("/orders")
    public List<OrderDetail> findAllOrders() {
        return service.getOrders();
    }

    @GetMapping("/orderById/{id}")
    public OrderDetail findOrderById(@PathVariable int id) {
        return service.getOrderById(id);
    }

    @PutMapping("/updateOrder")
    public OrderDetail updateOrder(@RequestBody OrderDetail orderDetail) {
        return service.updateOrder(orderDetail);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id) {
        return service.deleteOrder(id);
    }

}

package com.example.test2asm.service;

import com.example.test2asm.entity.OrderDetail;
import com.example.test2asm.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository repository;

    public OrderDetail saveOrder(OrderDetail orderDetail) {
        return repository.save(orderDetail);
    }

    public List<OrderDetail> saveOrders(List<OrderDetail> orderDetails) {
        return repository.saveAll(orderDetails);
    }

    public OrderDetail getOrderById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<OrderDetail> getOrders() {
        return repository.findAll();
    }

    public String deleteOrder(int id) {
        repository.deleteById(id);
        return "Order " + id + "deleted";
    }

    public OrderDetail updateOrder(OrderDetail orderDetail) {
        OrderDetail existOrder = repository.findById(orderDetail.getDetail_id()).orElse(null);
        existOrder.setOrder(orderDetail.getOrder());
        existOrder.setProduct(orderDetail.getProduct());
        existOrder.setDetail_quantity(orderDetail.getDetail_quantity());
        existOrder.setDetail_price(orderDetail.getDetail_price());
        return repository.save(existOrder);
    }
}

package com.example.test2asm.service;

import com.example.test2asm.entity.OrderDetail;
import com.example.test2asm.entity.Staff;
import com.example.test2asm.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

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

    //For testing
    public List<OrderDetail> getOrders() {
        return repository.findAll();
    }

    public Page<OrderDetail> findAllOrder(Pageable pageable){
        return (Page<OrderDetail>) repository.findAllOrder(pageable);
    }


    public String deleteOrder(int id) {
        repository.deleteById(id);
        return "Order " + id + "deleted";
    }

    public OrderDetail updateOrder(OrderDetail orderDetail) {
        OrderDetail existOrder = repository.findById(orderDetail.getDetail_id()).orElse(null);
        existOrder.setOrder(orderDetail.getOrder());
        existOrder.setProduct(orderDetail.getProduct());
        existOrder.setQuantity(orderDetail.getQuantity());
        existOrder.setPrice(orderDetail.getPrice());
        return repository.save(existOrder);
    }
}

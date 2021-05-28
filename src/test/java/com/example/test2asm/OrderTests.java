package com.example.test2asm;

import com.example.test2asm.entity.*;
import com.example.test2asm.repository.OrderDetailRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderTests {

    @Autowired
    private OrderDetailRepository repository;

    private OOrder order;
    private Product product;
    private Staff staff;
    private Provider provider;
    private Category category;


    @Test
    @Rollback(value = false)
    public void testCreateOrder() {
        OOrder order = new OOrder();
        Product product = new Product();
        OrderDetail orderDetail = new OrderDetail(order,product,3);
        OrderDetail savedDetail = repository.save(orderDetail);

        assertNotNull(savedDetail);
    }


}

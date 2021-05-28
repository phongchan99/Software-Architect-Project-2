package com.example.test2asm;

import com.example.test2asm.entity.OOrder;
import com.example.test2asm.entity.OrderDetail;
import com.example.test2asm.entity.Product;
import com.example.test2asm.repository.OrderDetailRepository;
import com.example.test2asm.service.OrderService;
import javassist.NotFoundException;
import org.aspectj.weaver.ast.Or;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class OrderServiceTests {

    @InjectMocks
    private OrderService service;
    @Mock
    private OrderDetailRepository repository;

    @Test
    public void findOrderTest() {
        OrderDetail orderDetail1;
        Mockito.when(repository.findById(1)).thenReturn(
                Optional.of(orderDetail1 = new OrderDetail(new OOrder(), new Product(), 1))
        );

        orderDetail1.setDetail_id(1);
        assertEquals(1, orderDetail1.getDetail_id());
    }

    @Test
    public void findAllOrderTest() {
        OrderDetail order1 = new OrderDetail();
        OrderDetail order2 = new OrderDetail();
        OrderDetail order3 = new OrderDetail();
        order1.setDetail_id(1);
        order2.setDetail_id(2);
        order3.setDetail_id(3);

        Mockito.when(repository.findAll())
                .thenReturn(Arrays.asList(order1, order2, order3));
        List<OrderDetail> orderDetails = service.getOrders();

        assertEquals(1, orderDetails.get(0).getDetail_id());
        assertEquals(2, orderDetails.get(1).getDetail_id());
        assertEquals(3, orderDetails.get(2).getDetail_id());
    }

    @Test
    public void findOrderNotFound() throws NotFoundException {
        Mockito.when(repository.findById(1)).thenReturn(
                Optional.empty()
        );
        OrderDetail orderDetail = service.getOrderById(1);
    }

}

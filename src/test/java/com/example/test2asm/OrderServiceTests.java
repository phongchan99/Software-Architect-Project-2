package com.example.test2asm;

import com.example.test2asm.entity.OOrder;
import com.example.test2asm.entity.OrderDetail;
import com.example.test2asm.entity.Product;
import com.example.test2asm.repository.OrderDetailRepository;
import com.example.test2asm.service.OrderService;
import javassist.NotFoundException;
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
                Optional.of(orderDetail1 = new OrderDetail(new OOrder(), new Product(), 0))
        );

        orderDetail1.setDetail_id(1);
        assertEquals(1, orderDetail1.getDetail_id());
    }

    @Test
    public void findAllOrderTest() {
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(
                new OrderDetail(new OOrder(), new Product(), 11),
                new OrderDetail(new OOrder(), new Product(), 22),
                new OrderDetail(new OOrder(), new Product(), 33)
        ));
        List<OrderDetail> orderDetails = service.getOrders();

        assertEquals(11, orderDetails.get(0).getDetail_quantity());
        assertEquals(22, orderDetails.get(1).getDetail_quantity());
        assertEquals(33, orderDetails.get(2).getDetail_quantity());
    }

    @Test
    public void findOrderNotFound() throws NotFoundException {
        Mockito.when(repository.findById(1)).thenReturn(
                Optional.empty()
        );
        OrderDetail orderDetail = service.getOrderById(1);
    }

}

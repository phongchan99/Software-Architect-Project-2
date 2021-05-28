package com.example.test2asm;

import com.example.test2asm.controller.OrderController;
import com.example.test2asm.entity.OOrder;
import com.example.test2asm.entity.OrderDetail;
import com.example.test2asm.entity.Product;
import com.example.test2asm.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService service;

    @Test
    public void findAllOrders() throws Exception {
        when(service.getOrders()).thenReturn(Arrays.asList(
                new OrderDetail(new OOrder(), new Product(), 11),
                new OrderDetail(new OOrder(), new Product(), 22),
                new OrderDetail(new OOrder(), new Product(), 33)
        ));

        mockMvc.perform(
                MockMvcRequestBuilders.get("/orders")
        ).andExpect(status().isOk())
                .andExpect(content().json("[{}, {}, {}]"));
    }

    @Test
    public void findAllEmpty() throws Exception {
        when(service.getOrders()).thenReturn(Collections.emptyList());

        mockMvc.perform(
                MockMvcRequestBuilders.get("/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}

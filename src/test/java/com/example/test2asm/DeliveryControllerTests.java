package com.example.test2asm;

import com.example.test2asm.controller.DeliveryController;
import com.example.test2asm.entity.DeliveryDetail;
import com.example.test2asm.service.DeliveryService;
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
@WebMvcTest(DeliveryController.class)
public class DeliveryControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DeliveryService service;

    @Test
    public void findAllDelivery() throws Exception {
        when(service.getDeliveries()).thenReturn(Arrays.asList(
                new DeliveryDetail(), new DeliveryDetail(), new DeliveryDetail()));

        mockMvc.perform(
                MockMvcRequestBuilders.get("/deliveries")
        ).andExpect(status().isOk())
                .andExpect(content().json("[{}, {}, {}]"));
    }

    @Test
    public void findAllEmpty() throws Exception {
        when(service.getDeliveries()).thenReturn(Collections.emptyList());

        mockMvc.perform(
                MockMvcRequestBuilders.get("/deliveries"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}

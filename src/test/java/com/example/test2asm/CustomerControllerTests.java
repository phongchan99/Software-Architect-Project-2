package com.example.test2asm;

import com.example.test2asm.controller.CustomerController;
import com.example.test2asm.entity.Customer;
import com.example.test2asm.service.CustomerService;
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
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    @Test
    public void findAllCustomers() throws Exception {
        when(service.getCustomers()).thenReturn(Arrays.asList(
                new Customer("Phong", "", "","","",""),
                new Customer("Khang", "", "","","",""),
                new Customer("Chris", "", "","","","")
        ));

        mockMvc.perform(
                MockMvcRequestBuilders.get("/customers"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}, {}]")
        );
    }

    @Test
    public void findAllEmpty() throws Exception {
        when(service.getCustomers()).thenReturn(Collections.emptyList());

        mockMvc.perform(
                MockMvcRequestBuilders.get("/customers"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}

package com.example.test2asm;

import com.example.test2asm.controller.SaleInvoiceController;
import com.example.test2asm.entity.SaleInvoiceDetail;
import com.example.test2asm.service.SaleInvoiceService;
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
@WebMvcTest(SaleInvoiceController.class)
public class SaleInvoiceControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SaleInvoiceService service;

    @Test
    public void findAllInvoices() throws Exception {
        when(service.getInvoices()).thenReturn(Arrays.asList(
                new SaleInvoiceDetail(), new SaleInvoiceDetail(), new SaleInvoiceDetail()
        ));
        mockMvc.perform(
                MockMvcRequestBuilders.get("/invoices"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}, {}]"));
    }

    @Test
    public void findAllEmpty() throws Exception {
        when(service.getInvoices()).thenReturn(Collections.emptyList());

        mockMvc.perform(
                MockMvcRequestBuilders.get("/invoices"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}

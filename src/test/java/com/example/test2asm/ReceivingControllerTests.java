package com.example.test2asm;

import com.example.test2asm.controller.ReceivingController;
import com.example.test2asm.entity.ReceivingDetail;
import com.example.test2asm.service.ReceivingService;
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
@WebMvcTest(ReceivingController.class)
public class ReceivingControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ReceivingService service;

    @Test
    public void findAllReceivings() throws Exception {
        when(service.getReceivings()).thenReturn(Arrays.asList(
                new ReceivingDetail(), new ReceivingDetail(), new ReceivingDetail()
        ));
        mockMvc.perform(
                MockMvcRequestBuilders.get("/receivings"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}, {}]"));
    }

    @Test
    public void findAllEmpty() throws Exception {
        when(service.getReceivings()).thenReturn(Collections.emptyList());

        mockMvc.perform(
                MockMvcRequestBuilders.get("/receivings"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}

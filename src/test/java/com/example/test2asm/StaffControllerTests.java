package com.example.test2asm;

import com.example.test2asm.controller.StaffController;
import com.example.test2asm.entity.Staff;
import com.example.test2asm.service.StaffService;
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
@WebMvcTest(StaffController.class)
public class StaffControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StaffService service;

    @Test
    public void findAllStaffs() throws Exception {
        when(service.getStaffs()).thenReturn(Arrays.asList(
                new Staff("Phong", "", "", ""),
                new Staff("Chris", "", "", ""),
                new Staff("Khang", "", "", "")
        ));

        mockMvc.perform(
                MockMvcRequestBuilders.get("/staffs"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}, {}, {}]"));
    }

    @Test
    public void findAllEmpty() throws Exception {
        when(service.getStaffs()).thenReturn(Collections.emptyList());

        mockMvc.perform(
                MockMvcRequestBuilders.get("/staffs"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}

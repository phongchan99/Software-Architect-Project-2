package com.example.test2asm;

import com.example.test2asm.entity.Staff;
import com.example.test2asm.repository.StaffRepository;
import com.example.test2asm.service.StaffService;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class StaffServiceTests {

    @InjectMocks
    private StaffService service;
    @Mock
    private StaffRepository repository;

    @Test
    public void findStaffTest() {
        Mockito.when(repository.findById(1)).thenReturn(
                Optional.of(new Staff("Phong", "", "", ""))
        );

        Staff staff = service.getStaffById(1);
        assertEquals("Phong", staff.getName());
    }

    @Test
    public void findAllStaffs() {
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(
                new Staff("Phong", "", "", ""),
                new Staff("Chris", "", "", ""),
                new Staff("Khang", "", "", "")
        ));

        List<Staff> staffs = service.getStaffs();

        assertEquals("Phong", staffs.get(0).getName());
        assertEquals("Chris", staffs.get(1).getName());
        assertEquals("Khang", staffs.get(2).getName());
    }

    @Test
    public void findStaffNotFound() throws NotFoundException {
        Mockito.when(repository.findById(1)).thenReturn(
                Optional.empty()
        );
        Staff staff = service.getStaffById(1);
    }


}

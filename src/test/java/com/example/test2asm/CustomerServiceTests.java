package com.example.test2asm;

import com.example.test2asm.entity.Customer;
import com.example.test2asm.repository.CustomerRepository;
import com.example.test2asm.service.CustomerService;
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
public class CustomerServiceTests {

    @InjectMocks
    private CustomerService service;
    @Mock
    private CustomerRepository repository;

    @Test
    public void findCustomerTest() {
        Mockito.when(repository.findById(1)).thenReturn(
                Optional.of(new Customer("Phong", "", "","","",""))
        );

        Customer customer = service.getCustomerById(1);

        assertEquals("Phong", customer.getName());
    }

    @Test
    public void findAllCustomerTest() {
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(
                new Customer("Phong", "", "","","",""),
                new Customer("Chris", "", "","","",""),
                new Customer("Khang", "", "","","","")
        ));

        List<Customer> customers = service.getCustomers();

        assertEquals("Phong", customers.get(0).getName());
        assertEquals("Chris", customers.get(1).getName());
        assertEquals("Khang", customers.get(2).getName());
    }

    @Test
    public void findCustomerNotFound() throws NotFoundException {
        Mockito.when(repository.findById(1)).thenReturn(
                Optional.empty()
        );
        Customer customer = service.getCustomerById(1);
    }
}

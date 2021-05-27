package com.example.test2asm.repository;

import com.example.test2asm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByName(String name);

    Customer findByAddress(String address);

    Customer findByPhone(String phone);
}

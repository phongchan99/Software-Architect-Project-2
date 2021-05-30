package com.example.test2asm.repository;

import com.example.test2asm.entity.Customer;
import com.example.test2asm.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByAddress(String address);

    Customer findByPhone(String phone);

    @Query(value = "SELECT * FROM Customer WHERE name like :name order by name asc",
            countQuery = "SELECT count(*) FROM Customer WHERE name like :name",
            nativeQuery = true)
    Page<Customer> findByName(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT * FROM Customer order by name asc",
            countQuery = "SELECT count(*) FROM Customer ",
            nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable);
}

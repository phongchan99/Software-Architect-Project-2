package com.example.test2asm.repository;

import com.example.test2asm.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    Customer findByName(String name);

    Customer findByAddress(String address);

    Customer findByPhone(String phone);

    @Query(value = "SELECT * FROM Customer WHERE name like :name order by name desc",
            countQuery = "SELECT count(*) FROM Customer WHERE name like :name",
            nativeQuery = true)
    Page<Customer> findByName(@Param("name") String name, Pageable pageable);
}

package com.example.test2asm.repository;

import com.example.test2asm.entity.OOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OOrder,Integer> {
    OOrder findByDate(String ate);
}

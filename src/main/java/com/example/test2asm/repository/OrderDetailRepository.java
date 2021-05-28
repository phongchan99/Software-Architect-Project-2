package com.example.test2asm.repository;

import com.example.test2asm.entity.OrderDetail;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
@Configuration
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {

}

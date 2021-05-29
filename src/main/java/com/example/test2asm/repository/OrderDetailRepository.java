package com.example.test2asm.repository;

import com.example.test2asm.entity.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {


    @Query(value = "SELECT * FROM orderdetail ",
            countQuery = "SELECT count(*) FROM orderdetail ",
            nativeQuery = true)
    Page<OrderDetail> findAll(Pageable pageable);
}

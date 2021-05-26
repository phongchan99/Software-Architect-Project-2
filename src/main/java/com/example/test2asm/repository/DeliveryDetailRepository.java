package com.example.test2asm.repository;

import com.example.test2asm.entity.Delivery;
import com.example.test2asm.entity.DeliveryDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryDetailRepository extends JpaRepository<DeliveryDetail,Integer> {
}

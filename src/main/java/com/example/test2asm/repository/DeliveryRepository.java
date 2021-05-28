package com.example.test2asm.repository;

import com.example.test2asm.entity.DeliveryNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<DeliveryNote,Integer> {
}

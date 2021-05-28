package com.example.test2asm.repository;

import com.example.test2asm.entity.DeliveryNoteDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryDetailRepository extends JpaRepository<DeliveryNoteDetail,Integer> {
}

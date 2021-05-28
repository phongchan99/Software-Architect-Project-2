package com.example.test2asm.repository;

import com.example.test2asm.entity.ReceivingNoteDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceivingDetailRepository extends JpaRepository<ReceivingNoteDetail,Integer> {
    //void findByEventDateGreaterThanAndEventDateLessThan(Date startDate, Date endDate);
}

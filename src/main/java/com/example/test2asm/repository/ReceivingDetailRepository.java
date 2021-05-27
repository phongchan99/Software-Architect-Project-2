package com.example.test2asm.repository;

import com.example.test2asm.entity.ReceivingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ReceivingDetailRepository extends JpaRepository<ReceivingDetail,Integer> {
    //void findByEventDateGreaterThanAndEventDateLessThan(Date startDate, Date endDate);
}

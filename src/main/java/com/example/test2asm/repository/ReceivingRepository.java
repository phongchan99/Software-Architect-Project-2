package com.example.test2asm.repository;


import com.example.test2asm.entity.ReceivingNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceivingRepository extends JpaRepository<ReceivingNote,Integer> {
}

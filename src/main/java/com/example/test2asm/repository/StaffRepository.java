package com.example.test2asm.repository;

import com.example.test2asm.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {

//    Staff findBystaff_name(String staff_name);
}

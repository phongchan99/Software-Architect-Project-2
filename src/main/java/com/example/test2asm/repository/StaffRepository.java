package com.example.test2asm.repository;

import com.example.test2asm.entity.Customer;
import com.example.test2asm.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {

    @Query(value = "SELECT * FROM Staff WHERE name like :name order by name asc",
            countQuery = "SELECT count(*) FROM Staff WHERE name like :name",
            nativeQuery = true)
    Page<Staff> findByName(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT * FROM Staff order by name asc",
            countQuery = "SELECT count(*) FROM Staff ",
            nativeQuery = true)
    Page<Staff> findAllStaff(Pageable pageable);


}

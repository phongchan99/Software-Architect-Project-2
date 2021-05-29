package com.example.test2asm.service;

import com.example.test2asm.entity.Staff;
import com.example.test2asm.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository repository;

    public Staff saveStaff(Staff staff) {
        return repository.save(staff);
    }

    public List<Staff> saveStaffs(List<Staff> staffs) {
        return repository.saveAll(staffs);
    }

    public Staff getStaffById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Page<Staff> findByName(String name, Pageable pageable){
        return (Page<Staff>) repository.findByName("%"+name+"%", pageable);
    }

    public Page<Staff> findAll(Pageable pageable){
        return (Page<Staff>) repository.findAll(pageable);
    }

    //For testing
    public List<Staff> getStaffs() {
        return repository.findAll();
    }

    public String deleteStaff(int id) {
        repository.deleteById(id);
        return "Staff " + id + " deleted";
    }

    public Staff updateStaff(Staff staff) {
        Staff existStaff = repository.findById(staff.getStaff_id()).orElse(null);
        existStaff.setName(staff.getName());
        existStaff.setStaff_address(staff.getStaff_address());
        existStaff.setStaff_phone(staff.getStaff_phone());
        existStaff.setStaff_email(staff.getStaff_email());
        return repository.save(existStaff);
    }

}


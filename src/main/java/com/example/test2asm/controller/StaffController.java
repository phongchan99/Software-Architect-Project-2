package com.example.test2asm.controller;

import com.example.test2asm.entity.Customer;
import com.example.test2asm.entity.Staff;
import com.example.test2asm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaffController {

    @Autowired
    private StaffService service;

    @PostMapping("/addStaff")
    public Staff addStaff(@RequestBody Staff staff) {
        return service.saveStaff(staff);
    }

    @PostMapping("/addStaffs")
    public List<Staff> addStaffs(@RequestBody List<Staff> staff) {
        return service.saveStaffs(staff);
    }

    @GetMapping("/staffs")
    public List<Staff> findAllStaffs() {
        return service.getStaffs();
    }

    @GetMapping("/staffById/{id}")
    public Staff findStaffById(@PathVariable int id) {
        return service.getStaffById(id);
    }

//    @GetMapping("/staffByName/{name}")
//    public Staff findStaffByName(@PathVariable String name) {
//        return service.getStaffByName(name);
//    }

    @PutMapping("/updateStaff")
    public Staff updateStaff(@RequestBody Staff staff) {
        return service.updateStaff(staff);
    }

    @DeleteMapping("/deleteStaff/{id}")
    public String deleteStaff(@PathVariable int id) {
        return service.deleteStaff(id);
    }

    @GetMapping( "/staffByName/{name}/{pageSize},{pageNo}")
    public List<Staff> findStaffByName(@PathVariable String name, @PathVariable int pageNo, @PathVariable  int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return this.service.findByName(name,(PageRequest) pageable).getContent();
    }

    @GetMapping( "/staffAll/{pageSize},{pageNo}")
    public List<Staff> findAll(@PathVariable int pageSize,@PathVariable  int pageNo){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return this.service.findAll((PageRequest) pageable).getContent();
    }
}

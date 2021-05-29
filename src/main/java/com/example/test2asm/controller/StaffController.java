package com.example.test2asm.controller;

import com.example.test2asm.entity.Staff;
import com.example.test2asm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    @GetMapping( "/staffs/{pageSize},{pageNo}")
    public List<Staff> findAll(@PathVariable int pageSize,@PathVariable  int pageNo){
        PageRequest pageable = PageRequest.of(pageNo,pageSize);
        return this.service.findAll(pageable).getContent();
    }

    @GetMapping("/staffById/{id}")
    public Staff findStaffById(@PathVariable int id) {
        return service.getStaffById(id);
    }

    @GetMapping( "/staffByName/{name}/{pageSize},{pageNo}")
    public List<Staff> StaffByName(@PathVariable String name, @PathVariable int pageNo, @PathVariable  int pageSize){
        PageRequest pageable = PageRequest.of(pageNo,pageSize);
        return this.service.findByName(name, pageable).getContent();
    }

    @PutMapping("/updateStaff")
    public Staff updateStaff(@RequestBody Staff staff) {
        return service.updateStaff(staff);
    }

    @DeleteMapping("/deleteStaff/{id}")
    public String deleteStaff(@PathVariable int id) {
        return service.deleteStaff(id);
    }

}

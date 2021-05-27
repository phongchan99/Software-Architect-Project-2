package com.example.test2asm.controller;

import com.example.test2asm.entity.Staff;
import com.example.test2asm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/staffByName/{name}")
    public Staff findStaffByName(@PathVariable String name) {
        return service.getStaffByName(name);
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

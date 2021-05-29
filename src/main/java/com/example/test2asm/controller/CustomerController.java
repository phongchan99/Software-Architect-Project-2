package com.example.test2asm.controller;

import com.example.test2asm.entity.Customer;
import com.example.test2asm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.saveCustomer(customer);
    }

    @PostMapping("/addCustomers")
    public List<Customer> addCustomers(@RequestBody List<Customer> customers) {
        return service.saveCustomers(customers);
    }

    @GetMapping("/customers")
    public List<Customer> findAllCustomers() {
        return service.getCustomers();
    }

//    @GetMapping("/customerByName/{name}")
//    public Customer findCustomerByName(@PathVariable String name) {
//        return service.getCustomerByName(name);
//    }

    @GetMapping("/customerByAddress/{address}")
    public Customer findCustomerByAddress(@PathVariable String address) {
        return service.getCustomerByAddress(address);
    }

    @GetMapping("/customerByPhone/{phone}")
    public Customer findCustomerByPhone(@PathVariable String phone) {
        return service.getCustomerByPhone(phone);
    }

    @GetMapping("/customerById/{id}")
    public Customer findCustomerById(@PathVariable int id) {
        return service.getCustomerById(id);
    }

    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return service.updateCustomer(customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return service.deleteCustomer(id);
    }

    @RequestMapping(path = "/customerByName/search", method = RequestMethod.GET)
    public List<Customer> findCustomerByName(@RequestParam String name,@RequestParam int pageNo, @RequestParam  int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return this.service.findByName(name,(PageRequest) pageable).getContent();
    }
}

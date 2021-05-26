package com.example.test2asm.service;

import com.example.test2asm.entity.Customer;
import com.example.test2asm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> saveCustomers(List<Customer> customers) {
        return repository.saveAll(customers);
    }

    public Customer getCustomerById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    public String deleteCustomer(int id) {
        repository.deleteById(id);
        return "Customer " + id + " deleted";
    }

    public Customer updateCustomer(Customer customer) {
        Customer existCustomer = repository.findById(customer.getCustomer_id()).orElse(null);
        existCustomer.setCustomer_name(customer.getCustomer_name());
        existCustomer.setCustomer_address(customer.getCustomer_address());
        existCustomer.setCustomer_phone(customer.getCustomer_phone());
        existCustomer.setCustomer_fax(customer.getCustomer_fax());
        existCustomer.setCustomer_email(customer.getCustomer_email());
        existCustomer.setCustomer_contactPerson(customer.getCustomer_contactPerson());
        return repository.save(existCustomer);
    }
}

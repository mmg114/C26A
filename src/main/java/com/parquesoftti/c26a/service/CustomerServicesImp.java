package com.parquesoftti.c26a.service;

import com.parquesoftti.c26a.model.Customer;
import com.parquesoftti.c26a.model.Order;
import com.parquesoftti.c26a.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServicesImp implements CustomerService{
   final  CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer customersTmp = customerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("customer not found"));
          customersTmp.setCustomerName(customer.getCustomerName());
          customersTmp.setEmail(customer.getEmail());
          customersTmp.setPhoneNumber(customer.getPhoneNumber());
       return customerRepository.save(customersTmp);
    }

    @Override
    public void delete(Long id) {
            customerRepository.deleteById(id);
    }
}

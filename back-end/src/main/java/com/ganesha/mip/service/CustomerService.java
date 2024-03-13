package com.ganesha.mip.service;


import com.ganesha.mip.model.jpa.CustomerEntity;
import com.ganesha.mip.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerEntity getCustomerDetails(String customerId)
    {
        return customerRepository.findById(customerId).get();
    }
}

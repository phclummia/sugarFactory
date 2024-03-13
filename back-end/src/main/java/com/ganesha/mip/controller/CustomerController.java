package com.ganesha.mip.controller;


import com.ganesha.mip.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*",value = "*")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(path = "api/customer/{Id}")
    public ResponseEntity getCustomerById(@PathVariable String Id)
    {
        return  ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerDetails(Id));
    }


}

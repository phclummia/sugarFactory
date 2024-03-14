package com.ganesha.mip.controller;


import com.ganesha.mip.model.dto.BuyCustomerProductDTO;
import com.ganesha.mip.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "api/customer/{Id}/buy")

    public ResponseEntity buyProductBucket(@PathVariable String Id,@RequestBody BuyCustomerProductDTO customerProductDTO)

    {
        customerService.buyCustomerProduct(Id,customerProductDTO);
        return  ResponseEntity.status(HttpStatus.OK).body("Product Bucket invested succesfully");
    }


}

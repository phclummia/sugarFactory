package com.ganesha.mip.controller;


import com.ganesha.mip.repository.ProductBucketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*",value = "*")
public class ProductBucketController {

    private final ProductBucketRepository productBucketRepository;

    @GetMapping(path = "api/productbucket")
    public ResponseEntity getCustomerById()
    {
        return  ResponseEntity.status(HttpStatus.OK).body(productBucketRepository.findAll());
    }

}

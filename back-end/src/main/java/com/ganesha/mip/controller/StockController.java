package com.ganesha.mip.controller;


import com.ganesha.mip.repository.StockRepository;
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
public class StockController {

    private final StockRepository stockRepository;

    @GetMapping(path = "api/stock")
    public ResponseEntity getCustomerById()
    {
        return  ResponseEntity.status(HttpStatus.OK).body(stockRepository.findAll());
    }
}

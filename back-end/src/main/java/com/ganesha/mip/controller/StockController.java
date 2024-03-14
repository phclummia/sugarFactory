package com.ganesha.mip.controller;


import com.ganesha.mip.repository.StockRepository;
import com.ganesha.mip.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*",value = "*")
public class StockController {

    private final StockRepository stockRepository;

    private final StockService stockService;

    @GetMapping(path = "api/stock")
    public ResponseEntity getCustomerById()
    {
        return  ResponseEntity.status(HttpStatus.OK).body(stockRepository.findAll());
    }

    @GetMapping(path = "api/stock/import/{name}")
    public ResponseEntity importCsv(@PathVariable  String name) throws Exception
    {
        String path="C:\\Users\\RU80NU\\Projects\\sugarFactory\\data\\"+name+".csv";
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }

        stockService.importStockList(name,records);
        return  ResponseEntity.status(HttpStatus.OK).body(stockRepository.findAll());
    }

}

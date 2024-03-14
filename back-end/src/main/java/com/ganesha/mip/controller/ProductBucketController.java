package com.ganesha.mip.controller;


import com.ganesha.mip.repository.ProductBucketRepository;
import com.ganesha.mip.service.ProductBucketService;
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
public class ProductBucketController {

    private final ProductBucketRepository productBucketRepository;

    private final ProductBucketService productBucketService;

    @GetMapping(path = "api/productbucket")
    public ResponseEntity getAllBuckets()
    {
        return  ResponseEntity.status(HttpStatus.OK).body(productBucketRepository.findAll());
    }

    @GetMapping(path = "api/productbucket/import/{stockId}/{safeName}")
    public ResponseEntity importCsv(@PathVariable String stockId,@PathVariable String safeName) throws Exception
    {
        String path="C:\\Users\\RU80NU\\Projects\\sugarFactory\\data\\productDetail\\"+stockId+".csv";
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }

        productBucketService.importProductDetail(safeName,stockId,records);
        return  ResponseEntity.status(HttpStatus.OK).body("Succesfully imported");
    }

    @GetMapping(path = "api/productbucket/import/performanceDetail/agressive")
    public ResponseEntity importCsv() throws Exception
    {
        String excelName="AgressiveDetail2";
        String stock1="LLY";
        String stock2="JPA";
        String stock3="AVGO";
        String path="C:\\Users\\RU80NU\\Projects\\sugarFactory\\data\\productDetail\\"+excelName+".csv";
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        }

        productBucketService.importProductDetailPerformanceString(stock1,stock2,stock3,records);
        return  ResponseEntity.status(HttpStatus.OK).body("Succesfully imported");
    }

}

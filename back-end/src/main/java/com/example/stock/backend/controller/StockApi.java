package com.example.stock.backend.controller;

import com.example.stock.backend.model.PackageItem;
import com.example.stock.backend.model.PackageResponse;
import com.example.stock.backend.model.PortfolioItem;
import com.example.stock.backend.model.PortfolioResponse;
import com.example.stock.backend.model.StockItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockApi {


  @GetMapping("/{customerNum}/portfolio")
  @CrossOrigin()
  ResponseEntity<PortfolioResponse> getCustomerPortfolio(@PathVariable String customerNum) {

    PortfolioResponse response = new PortfolioResponse();
    response.setCustomerNumber(customerNum);
    response.setPortfolio(new ArrayList<>());

    response.getPortfolio().add(PortfolioItem.builder()
        .stockCode("GOOGLE")
        .stockDescription("Alphabet")
        .currentValue("25,54 usd")
        .todayChange("%2")
        .build());

    response.getPortfolio().add(PortfolioItem.builder()
        .stockCode("TSLA")
        .stockDescription("Tesla")
        .currentValue("25,54 usd")
        .todayChange("%2")
        .build());

    response.getPortfolio().add(PortfolioItem.builder()
        .stockCode("UDMY")
        .stockDescription("Udemy")
        .currentValue("25,54 usd")
        .todayChange("%2")
        .build());

    response.getPortfolio().add(PortfolioItem.builder()
        .stockCode("INTL")
        .stockDescription("Intel")
        .currentValue("25,54 usd")
        .todayChange("%2")
        .build());

    return new ResponseEntity<>(response, HttpStatus.OK);

  }


  @GetMapping("/products")
  @CrossOrigin()
  ResponseEntity<PackageResponse> getPackages() {

    List<StockItem> stocks = new ArrayList<>();

    stocks.add(StockItem.builder().stockCode("GOOGLE")
        .stockDescription("Alphabet")
        .currentValue("25,54 usd")
        .todayChange("%2")
        .build());

    stocks.add(StockItem.builder().stockCode("TSLA")
        .stockDescription("Tesla")
        .currentValue("25,54 usd")
        .todayChange("%2")
        .build());

    stocks.add(StockItem.builder().stockCode("UDMY")
        .stockDescription("Udemy")
        .currentValue("25,54 usd")
        .todayChange("%2")
        .build());

    stocks.add(StockItem.builder().stockCode("INTL")
        .stockDescription("Intel")
        .currentValue("25,54 usd")
        .todayChange("%2")
        .build());

    List<PackageItem> packages = new ArrayList<>();
    packages.add(PackageItem.builder()
        .packageId("Safe001")
        .packageDescription("Safe")
        .stocks(stocks).build());

    packages.add(PackageItem.builder()
        .packageId("Mediud001")
        .packageDescription("Medium")
        .stocks(stocks).build());

    packages.add(PackageItem.builder()
        .packageId("Aggressive001")
        .packageDescription("Aggressive")
        .stocks(stocks).build());

    PackageResponse response = PackageResponse.builder()
        .packages(packages).build();

    return new ResponseEntity<>(response, HttpStatus.OK);

  }

}

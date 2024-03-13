package com.example.stock.backend.controller;

import com.example.stock.backend.model.PortfolioItem;
import com.example.stock.backend.model.PortfolioResponse;
import java.util.ArrayList;
import java.util.HashMap;
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
    Map<String, String> portfolio = new HashMap<>();

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

}

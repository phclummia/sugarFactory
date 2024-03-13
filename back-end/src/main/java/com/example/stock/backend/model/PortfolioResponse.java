package com.example.stock.backend.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PortfolioResponse {

  String customerNumber;
  List<PortfolioItem> portfolio;

}

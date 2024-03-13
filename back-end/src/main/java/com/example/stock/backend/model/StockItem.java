package com.example.stock.backend.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class StockItem {

  String stockCode;
  String stockDescription;
  String currentValue;
  String todayChange;

}

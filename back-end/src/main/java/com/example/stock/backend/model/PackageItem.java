package com.example.stock.backend.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PackageItem {

  String packageId;
  String packageDescription;
  List<StockItem> stocks;

}

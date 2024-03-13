package com.ganesha.mip.model.jpa;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "STOCK")
@Getter
@Setter
@NoArgsConstructor
public class StockEntity {

    @Id
    @Column(name="STOCK_ID")
    private String stockId;

    @Column(name="MARKET_CAP")
    private String marketCap;

    @OneToMany(mappedBy = "stockEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("stockEntity")
    private List<StockTrackingDetailEntity> stockTrackingDetailEntities = new ArrayList<>();

    public void addStockTransaction(StockTrackingDetailEntity stockEntity) {
        stockTrackingDetailEntities.add(stockEntity);
        stockEntity.setStockEntity(this);
    }

}

package com.ganesha.mip.model.jpa;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table( name = "PRODUCT_BUCKET_DETAIL_PERFORMANCE_DETAIL_AGRESSIVE")
@Getter
@Setter
@NoArgsConstructor
public class ProductBucketPerformanceDetailAgressiveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "PRODUCT_BUCKET_DETAIL_ID")
    private String productBucketDetailId;

    @ManyToOne()
    @JoinColumn(name = "PRODUCT_BUCKET_ID")
    private ProductBucketEntity productBucketEntity;

    @Column(name = "STOCK_1")
    private String stock1;
    @Column(name = "STOCK_2")
    private String stock2;
    @Column(name = "STOCK_3")
    private String stock3;

    @Column(name = "STOCK_1_NAME")
    private String stock1Name;
    @Column(name = "STOCK_2_NAME")
    private String stock2Name;
    @Column(name = "STOCK_3_NAME")
    private String stock3Name;


    @Column(name = "MON100EFT")
    private long mon100EFT;

    @Column(name = "UNIT_MON100EFT")
    private long unit_mon100eft;

    @Column(name = "SOLD_MON100EFT")
    private long sold_mon100eft;

    @Column(name = "BOUGHT_MON100EFT")
    private long bought_mon100eft;

    @Column(name = "STOCK_PRICE")
    private long stockPrice;

    @Column(name = "TOTAL_PRICE")
    private long totalPrice;

    @Column(name="TRANSACTION_DATE")
    private String date;

    @Column(name = "NUMBEROFUNIT")
    private long numberOfunit;

    @Column(name = "PER_UNIT_COST")
    private BigDecimal perUnitCost;



}

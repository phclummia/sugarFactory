package com.ganesha.mip.model.jpa;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "PRODUCT_BUCKET_DETAIL")
@Getter
@Setter
@NoArgsConstructor
public class ProductBucketDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "PRODUCT_BUCKET_DETAIL_ID")
    private String productBucketDetailId;

    @ManyToOne()
    @JoinColumn(name = "STOCK_ID")
    private StockEntity stockEntity;

    @ManyToOne()
    @JoinColumn(name = "PRODUCT_BUCKET_ID")
    private ProductBucketEntity productBucketEntity;

    @Column(name = "STOCK_PRICE")
    private long stockPrice;

    @Column(name="TRANSACTION_DATE")
    private String date;

    @Column(name = "UNIT")
    private long unit;
}

package com.ganesha.mip.model.jpa;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table( name = "PRODUCT_BUCKET_PERFORMANCE")
@Getter
@Setter
@NoArgsConstructor
public class ProductBucketPerformanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "PRODUCT_BUCKET_PERFORMANCE")
    private String productBucketPerformanceId;


    @Column(name="NEW_VALUE")
    private long value;

    @Column(name="DATE_OF_BUCKET")
    private String date;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_BUCKET_ID")
    private ProductBucketEntity productBucketEntity;

}

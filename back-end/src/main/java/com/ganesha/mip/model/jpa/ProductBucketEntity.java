package com.ganesha.mip.model.jpa;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "PRODUCT_BUCKET")
@Getter
@Setter
@NoArgsConstructor
public class ProductBucketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "PRODUCT_BUCKET_ID")
    private String productBucketId;

    @Column(name="PRODUCT_BUCKET_NAME")
    private String productBucketName;

    @Column(name="PRODUCT_VALUE")
    private long value;

    @Column(name="NUMBER_OF_UNIT")
    private long numberOfUnit;

    @OneToMany(mappedBy = "productBucketEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("productBucketEntity")
    private List<ProductBucketPerformanceEntity> productBucketPerformanceEntities = new ArrayList<>();

    public void addPerformance(ProductBucketPerformanceEntity entity) {
        productBucketPerformanceEntities.add(entity);
        entity.setProductBucketEntity(this);
    }

    @OneToMany(mappedBy = "productBucketEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("productBucketEntity")
    private List<ProductBucketDetailEntity> productBucketDetailEntities =
            new ArrayList<>();

    public void addInvolvedPartyRelationship(ProductBucketDetailEntity entity) {
        productBucketDetailEntities.add(entity);
        entity.setProductBucketEntity(this);
    }

}

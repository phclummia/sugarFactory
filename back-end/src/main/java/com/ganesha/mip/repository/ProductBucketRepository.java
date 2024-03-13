package com.ganesha.mip.repository;

import com.ganesha.mip.model.jpa.ProductBucketEntity;
import com.ganesha.mip.model.jpa.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBucketRepository extends JpaRepository<ProductBucketEntity, String> {
    
}
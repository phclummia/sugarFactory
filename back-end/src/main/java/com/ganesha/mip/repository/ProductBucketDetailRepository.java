package com.ganesha.mip.repository;

import com.ganesha.mip.model.jpa.ProductBucketDetailEntity;
import com.ganesha.mip.model.jpa.ProductBucketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBucketDetailRepository extends JpaRepository<ProductBucketDetailEntity, String> {
    
}
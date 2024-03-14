package com.ganesha.mip.repository;

import com.ganesha.mip.model.jpa.ProductBucketPerformanceDetailAgressiveEntity;
import com.ganesha.mip.model.jpa.ProductBucketPerformanceDetailSafeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBucketPerformanceDetailSafeRepository extends JpaRepository<ProductBucketPerformanceDetailSafeEntity, String> {
    
}
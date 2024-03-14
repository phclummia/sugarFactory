package com.ganesha.mip.repository;

import com.ganesha.mip.model.jpa.ProductBucketEntity;
import com.ganesha.mip.model.jpa.ProductBucketPerformanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductBucketPerformanceRepository extends JpaRepository<ProductBucketPerformanceEntity, String>{

    List<ProductBucketPerformanceEntity> findProductBucketPerformanceEntityByProductBucketEntityProductBucketId(String productBucketId);

}

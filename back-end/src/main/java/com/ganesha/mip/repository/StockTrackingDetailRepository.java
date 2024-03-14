package com.ganesha.mip.repository;

import com.ganesha.mip.model.jpa.StockEntity;
import com.ganesha.mip.model.jpa.StockTrackingDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockTrackingDetailRepository extends JpaRepository<StockTrackingDetailEntity, String> {
    
}
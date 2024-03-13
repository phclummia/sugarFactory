package com.ganesha.mip.repository;

import com.ganesha.mip.model.jpa.CustomerEntity;
import com.ganesha.mip.model.jpa.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockEntity, String> {
    
}
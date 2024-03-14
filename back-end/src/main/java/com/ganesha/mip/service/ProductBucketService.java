package com.ganesha.mip.service;


import com.ganesha.mip.model.jpa.ProductBucketDetailEntity;
import com.ganesha.mip.model.jpa.StockEntity;
import com.ganesha.mip.repository.ProductBucketDetailRepository;
import com.ganesha.mip.repository.ProductBucketRepository;
import com.ganesha.mip.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductBucketService {

    private final ProductBucketDetailRepository productBucketDetailRepository;

    private final ProductBucketRepository productBucketRepository;

    private final StockRepository stockRepository;

    public void importProductDetail(String safeId,String stockId,List<List<String>> records){

        for (var recordDetail: records) {

        ProductBucketDetailEntity productBucketDetailEntity=new ProductBucketDetailEntity();

        var referenceBucketEntity=productBucketRepository.getReferenceById(safeId);
        productBucketDetailEntity.setProductBucketEntity(referenceBucketEntity);

        var referenceStock=stockRepository.getReferenceById(stockId);
        productBucketDetailEntity.setStockEntity(referenceStock);

        productBucketDetailEntity.setUnit(Long.parseLong(recordDetail.get(0)));

        productBucketDetailEntity.setDate(recordDetail.get(1));

        productBucketDetailEntity.setStockPrice(Long.parseLong(recordDetail.get(2)));

        productBucketDetailRepository.save(productBucketDetailEntity);

        }

    }
}

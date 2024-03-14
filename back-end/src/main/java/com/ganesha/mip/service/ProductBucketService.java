package com.ganesha.mip.service;


import com.ganesha.mip.model.jpa.ProductBucketDetailEntity;
import com.ganesha.mip.model.jpa.ProductBucketPerformanceDetailAgressiveEntity;
import com.ganesha.mip.repository.ProductBucketDetailRepository;
import com.ganesha.mip.repository.ProductBucketPerformanceDetailAgressiveRepository;
import com.ganesha.mip.repository.ProductBucketRepository;
import com.ganesha.mip.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductBucketService {

    private final ProductBucketDetailRepository productBucketDetailRepository;

    private final ProductBucketRepository productBucketRepository;

    private final ProductBucketPerformanceDetailAgressiveRepository productBucketPerformanceDetailAgressiveRepository;

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

        public void importProductDetailPerformanceString(String stock_1_Name,String stock_2_Name,String stock_3_Name,List<List<String>> records){


            for (var recordDetail: records) {



                String date= recordDetail.get(0);
                String stock_1=recordDetail.get(1);
                String stock_2=recordDetail.get(2);
                String stock_3=recordDetail.get(3);
                long mon100eft=Long.parseLong(recordDetail.get(4));
                long  unitof100eft=Long.parseLong(recordDetail.get(5));
                long soldofmon100eft=Long.parseLong(recordDetail.get(6));;
                long boughtofmon100eft=Long.parseLong(recordDetail.get(7));;
                String safeId=recordDetail.get(8);;
                long stockPrice=Long.parseLong(recordDetail.get(9));;

                long totalPrice=Long.parseLong(recordDetail.get(10));
                long unit=Long.parseLong(recordDetail.get(11));;

                String perunit=recordDetail.get(12).replace(",",".");
                BigDecimal perUnitCost=new BigDecimal(perunit);





                ProductBucketPerformanceDetailAgressiveEntity productBucketDetailEntity=new ProductBucketPerformanceDetailAgressiveEntity();

                var referenceBucketEntity=productBucketRepository.getReferenceById(safeId);
                productBucketDetailEntity.setProductBucketEntity(referenceBucketEntity);

                productBucketDetailEntity.setDate(date);
                productBucketDetailEntity.setNumberOfunit(unit);
                productBucketDetailEntity.setStock1(stock_1);
                productBucketDetailEntity.setPerUnitCost(perUnitCost);
                productBucketDetailEntity.setStockPrice(stockPrice);
                productBucketDetailEntity.setStock2(stock_2);
                productBucketDetailEntity.setStock3(stock_3);
                productBucketDetailEntity.setTotalPrice(totalPrice);
                productBucketDetailEntity.setBought_mon100eft(boughtofmon100eft);
                productBucketDetailEntity.setSold_mon100eft(soldofmon100eft);
                productBucketDetailEntity.setUnit_mon100eft(unitof100eft);
                productBucketDetailEntity.setMon100EFT(mon100eft);
                productBucketDetailEntity.setStock1Name(stock_1_Name);
                productBucketDetailEntity.setStock2Name(stock_2_Name);
                productBucketDetailEntity.setStock3Name(stock_3_Name);


                productBucketPerformanceDetailAgressiveRepository.save(productBucketDetailEntity);

            }

    }
}

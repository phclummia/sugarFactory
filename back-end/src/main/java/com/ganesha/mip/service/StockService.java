package com.ganesha.mip.service;


import com.ganesha.mip.model.jpa.StockEntity;
import com.ganesha.mip.model.jpa.StockTrackingDetailEntity;
import com.ganesha.mip.repository.StockRepository;
import com.ganesha.mip.repository.StockTrackingDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockService {


    private final StockTrackingDetailRepository stockTrackingDetailRepository;

    private final StockRepository stockRepository;

    public void importStockList(String stockId, List<List<String>> records){

        long Defaultrsi=60;
        long enterRSI=71;
        long existRSI=49;

      Optional<StockEntity> stockEntityOptional =  stockRepository.findById(stockId);
      StockEntity stockEntity;
      if(stockEntityOptional.isPresent())
      {
         stockEntity=stockEntityOptional.get();
      }
      else{
          stockEntity=new StockEntity();
          stockEntity.setStockId(stockId);
          stockEntity.setMarketCap("Largecap");
          stockRepository.save(stockEntity);
      }

        for (var recordDetail:records) {
            StockTrackingDetailEntity stockTrackingDetailEntity=new StockTrackingDetailEntity();
            stockTrackingDetailEntity.setStockEntity(stockEntity);
            stockTrackingDetailEntity.setConditionEntry(enterRSI);
            stockTrackingDetailEntity.setConditionExit(existRSI);

           long rowNumber= recordDetail.stream().count();
            stockTrackingDetailEntity.setDate(recordDetail.get(0));
            stockTrackingDetailEntity.setCurrentPrice(Long.parseLong(recordDetail.get(1)));
            long itemRSI;
           if(rowNumber>2)
           {

              itemRSI=Long.parseLong(recordDetail.get(2));
           }
           else{
               itemRSI=Defaultrsi;
           }
            stockTrackingDetailEntity.setWeekRSI(itemRSI);

           if(itemRSI>=enterRSI)
           {
               stockTrackingDetailEntity.setEntered(true);
           }
           else{
               stockTrackingDetailEntity.setEntered(false);
           }

            if(itemRSI<existRSI)
            {
                stockTrackingDetailEntity.setExit(true);
            }
            else{
                stockTrackingDetailEntity.setExit(false);
            }

            stockTrackingDetailRepository.save(stockTrackingDetailEntity);
        }
    }
}

package com.ganesha.mip.service;


import com.ganesha.mip.model.dto.BuyCustomerProductDTO;
import com.ganesha.mip.model.jpa.*;
import com.ganesha.mip.repository.CustomerRepository;
import com.ganesha.mip.repository.ProductBucketPerformanceRepository;
import com.ganesha.mip.repository.ProductBucketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final ProductBucketRepository productBucketRepository;

    private final ProductBucketPerformanceRepository productBucketPerformanceRepository;



    public CustomerEntity getCustomerDetails(String customerId)
    {
        return customerRepository.findById(customerId).get();
    }

    public void buyCustomerProduct(String customerId, BuyCustomerProductDTO requestDto)
    {
        DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
      var productBucketDetailEntity=  productBucketRepository.findById(requestDto.getProductBucketId()).get();
      String today=LocalDate.now().format(dateFormat);

      List<ProductBucketPerformanceEntity> productBucketPerformanceEntityList=  productBucketPerformanceRepository.findProductBucketPerformanceEntityByProductBucketEntityProductBucketId(requestDto.getProductBucketId());

      var todayPerformanceEntity= productBucketPerformanceEntityList.stream().filter(p->p.getDate().equals(today)).findFirst();


        CustomerBucketDetailEntity customerBucketDetailEntity=new CustomerBucketDetailEntity();
        CustomerEntity customerEntity = customerRepository.findById(customerId).get();

        long totalUnit=0;
        for (CustomerBucketDetailEntity detailEntity : customerEntity.getCustomerBucketDetailEntities()) {

            if(!detailEntity.isSell()){
                totalUnit=totalUnit+detailEntity.getUnit();
            }
        }

        customerBucketDetailEntity.setCustomerEntity(customerEntity);

        ProductBucketEntity productBucketProxyEntity=productBucketRepository.getReferenceById(requestDto.getProductBucketId());

        customerBucketDetailEntity.setProductBucketEntity(productBucketProxyEntity);

        customerBucketDetailEntity.setEnteredDate(today);

        customerBucketDetailEntity.setSell(false);

        customerBucketDetailEntity.setMoneyForInvest(requestDto.getMoneyToInvest());

        long todayValue=todayPerformanceEntity.get().getValue();

        long perUnitPrice=todayValue/100;

        customerBucketDetailEntity.setUnit(perUnitPrice);
        customerBucketDetailEntity.setTotalUnit(totalUnit);


    }
}

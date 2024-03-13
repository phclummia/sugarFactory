package com.ganesha.mip.model.jpa;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "CUSTOMER_BUCKET_DETAIL")
@Getter
@Setter
@NoArgsConstructor
public class CustomerBucketDetailEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CUSTOMER_BUCKET_DETAIL_ID")
    private String customerBucketDetailId;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_BUCKET_ID")
    private ProductBucketEntity productBucketEntity;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customerEntity;

    @Column(name="UNIT")
    private long Unit;

    @Column(name="MONEY_FOR_INVEST")
    private long moneyForInvest;

    @Column(name="IS_SELL")
    private boolean isSell;

    @Column(name="TOTAL_UNIT")
    private long totalUnit;

    @Column(name = "ENTERED_DATE")
    private String enteredDate;

    @Column(name = "EXIT_DATE")
    private String exitDate;

    @Column(name="PER_UNIT")
    private BigDecimal perUnit;

    @Column(name="TARGET_AMOUNT")
    private BigDecimal targetAmount;

    @Column(name="STOP_LOSS")
    private BigDecimal stopLoss;

    @Column(name="STOP_PERCENTAGE")
    private long stopPercentage;

    @Column(name="TARGET_PERCENTAGE")
    private long targetPercentage;

}

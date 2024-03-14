package com.ganesha.mip.model.jpa;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table( name = "STOCK_TRANSACTION_DETAIL")
@Getter
@Setter
@NoArgsConstructor
public class StockTrackingDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "STOCK_TRANSACTION_ID")
    private String stockTransactionId;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "STOCK_ID")
    private StockEntity stockEntity;

    @Column(name="STOCK_DATE")
    private String date;

    @Column(name="weekRSI")
    private long weekRSI;

    @Column(name="CURRENT_PRICE")
    private long currentPrice;

    @Column(name="EMA")
    private long ema;

    @Column(name="CONDITION_ENTRY")
    private long conditionEntry;

    @Column(name="CONDITION_EXIT")
    private long conditionExit;

    @Column(name="IS_EXIT")
    private boolean isExit;
    @Column(name="IS_ENTERED")
    private boolean isEntered;
    @Column(name="PROFIT")
    private long profit;
    @Column(name="LOSS")
    private long loss;


}

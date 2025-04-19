package com.github.brms5.personal_finance_api.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "financial_balances")
@Getter
@Setter
public class FinancialBalanceEntity {

    @Id
    private String id;

    private String accountId;

    private BigDecimal totalAssets;
    private BigDecimal totalLiabilities;
    private BigDecimal netWorth;

    private Integer monthlyInflation;
    private Integer accumulatedInflationToSurpass;

    private BigDecimal totalBalance;

    private LocalDateTime calculationDate;
}

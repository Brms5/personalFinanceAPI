package com.github.brms5.personal_finance_api.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

@Document(collection = "financial_balances")
@Getter
@Setter
@Builder
public class FinancialBalanceEntity {

    @Id
    private String id;

    private String accountId;

    private Month referenceMonth;

    private BigDecimal totalAssets;
    private BigDecimal totalLiabilities;
    private BigDecimal netWorth;

    private Double monthlyInflation;
    private Double totalBalanceGrowthPercentage;

    private BigDecimal totalBalance;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

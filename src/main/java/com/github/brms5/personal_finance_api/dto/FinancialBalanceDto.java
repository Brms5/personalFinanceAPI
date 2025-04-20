package com.github.brms5.personal_finance_api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

@Getter
@Setter
@Builder
public class FinancialBalanceDto {

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

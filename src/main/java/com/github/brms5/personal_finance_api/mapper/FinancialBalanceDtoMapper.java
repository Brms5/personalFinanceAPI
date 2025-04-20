package com.github.brms5.personal_finance_api.mapper;

import com.github.brms5.personal_finance_api.dto.FinancialBalanceDto;
import com.github.brms5.personal_finance_api.entity.FinancialBalanceEntity;

public class FinancialBalanceDtoMapper {

    public static FinancialBalanceDto mapEntityToDto(FinancialBalanceEntity financialBalanceEntity) {
        return FinancialBalanceDto.builder()
                .accountId(financialBalanceEntity.getAccountId())
                .referenceMonth(financialBalanceEntity.getReferenceMonth())
                .totalAssets(financialBalanceEntity.getTotalAssets())
                .totalLiabilities(financialBalanceEntity.getTotalLiabilities())
                .netWorth(financialBalanceEntity.getNetWorth())
                .monthlyInflation(financialBalanceEntity.getMonthlyInflation())
                .totalBalanceGrowthPercentage(financialBalanceEntity.getTotalBalanceGrowthPercentage())
                .totalBalance(financialBalanceEntity.getTotalBalance())
                .createdAt(financialBalanceEntity.getCreatedAt())
                .updatedAt(financialBalanceEntity.getUpdatedAt())
                .build();
    }
}

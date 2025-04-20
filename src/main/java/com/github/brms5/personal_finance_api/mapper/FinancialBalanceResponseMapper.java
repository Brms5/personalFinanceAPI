package com.github.brms5.personal_finance_api.mapper;

import com.github.brms5.personal_finance_api.controller.response.FinancialBalanceResponse;
import com.github.brms5.personal_finance_api.dto.FinancialBalanceDto;

public class FinancialBalanceResponseMapper {

    public static FinancialBalanceResponse mapDtoToResponse(FinancialBalanceDto financialBalanceDto) {
        return FinancialBalanceResponse.builder()
                .accountId(financialBalanceDto.getAccountId())
                .referenceMonth(financialBalanceDto.getReferenceMonth())
                .totalAssets(financialBalanceDto.getTotalAssets())
                .totalLiabilities(financialBalanceDto.getTotalLiabilities())
                .netWorth(financialBalanceDto.getNetWorth())
                .monthlyInflation(financialBalanceDto.getMonthlyInflation())
                .totalBalanceGrowthPercentage(financialBalanceDto.getTotalBalanceGrowthPercentage())
                .totalBalance(financialBalanceDto.getTotalBalance())
                .createdAt(financialBalanceDto.getCreatedAt())
                .updatedAt(financialBalanceDto.getUpdatedAt())
                .build();
    }
}

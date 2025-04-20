package com.github.brms5.personal_finance_api.service;

import com.github.brms5.personal_finance_api.dto.FinancialBalanceDto;
import com.github.brms5.personal_finance_api.dto.InflationIndexDto;
import com.github.brms5.personal_finance_api.entity.FinancialAssetEntity;
import com.github.brms5.personal_finance_api.entity.FinancialBalanceEntity;
import com.github.brms5.personal_finance_api.entity.FinancialLiabilityEntity;
import com.github.brms5.personal_finance_api.mapper.FinancialBalanceDtoMapper;
import com.github.brms5.personal_finance_api.repository.FinancialAssetRepository;
import com.github.brms5.personal_finance_api.repository.FinancialBalanceRepository;
import com.github.brms5.personal_finance_api.repository.FinancialLiabilityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class FinancialBalanceService {

    private final InflationIndexService inflationIndexService;
    private final FinancialBalanceRepository financialBalanceRepository;
    private final FinancialAssetRepository financialAssetRepository;
    private final FinancialLiabilityRepository financialLiabilityRepository;

    public FinancialBalanceDto getFinancialBalanceByAccountIdAndReferenceMonth(String accountId, Month referenceMonth) {
        FinancialBalanceEntity financialBalanceEntity = financialBalanceRepository.findByAccountIdAndReferenceMonth(accountId, referenceMonth);
        if (Objects.isNull(financialBalanceEntity)) {
            throw new RuntimeException("Financial balance not found for the given account ID and reference month");
        }

        return FinancialBalanceDtoMapper.mapEntityToDto(financialBalanceEntity);
    }

    public void handleFinancialBalance(String accountId, Month referenceMonth) {
        FinancialBalanceEntity existingBalance = financialBalanceRepository.findByAccountIdAndReferenceMonth(accountId, referenceMonth);

        FinancialBalanceEntity financialBalanceEntity = buildFinancialBalance(accountId, referenceMonth);

        if (existingBalance != null) {
            financialBalanceEntity.setId(existingBalance.getId());
            financialBalanceEntity.setCreatedAt(existingBalance.getCreatedAt());
        } else {
            financialBalanceEntity.setCreatedAt(LocalDateTime.now());
        }

        financialBalanceRepository.save(financialBalanceEntity);
    }

    private FinancialBalanceEntity buildFinancialBalance(String accountId, Month referenceMonth) {
        BigDecimal totalAssets = calculateTotalAssets(accountId, referenceMonth);
        BigDecimal totalLiabilities = calculateTotalLiabilities(accountId, referenceMonth);
        BigDecimal netWorth = totalAssets.subtract(totalLiabilities);

        // dd/MM/yyyy format
        String date = String.format("%02d/%02d/%04d", 1, referenceMonth.getValue(), LocalDateTime.now().getYear());
        Double monthlyInflation = getMonthlyInflation(date);

        BigDecimal lastTotalBalance = getLastTotalBalance(accountId, referenceMonth);
        BigDecimal totalBalance = lastTotalBalance.add(netWorth);

        Double totalBalanceGrowthPercentage = calculateRealGrowthPercentage(lastTotalBalance, totalBalance, monthlyInflation);

        return FinancialBalanceEntity.builder()
                .accountId(accountId)
                .referenceMonth(referenceMonth)
                .totalAssets(totalAssets)
                .totalLiabilities(totalLiabilities)
                .netWorth(netWorth)
                .monthlyInflation(monthlyInflation)
                .totalBalance(totalBalance)
                .totalBalanceGrowthPercentage(totalBalanceGrowthPercentage)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    private BigDecimal calculateTotalAssets(String accountId, Month referenceMonth) {
        List<FinancialAssetEntity> financialAssets = financialAssetRepository.findAllByAccountIdAndReferenceMonth(accountId, referenceMonth);
        return financialAssets.stream()
                .map(FinancialAssetEntity::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateTotalLiabilities(String accountId, Month referenceMonth) {
        List<FinancialLiabilityEntity> financialLiabilities = financialLiabilityRepository.findAllByAccountIdAndReferenceMonth(accountId, referenceMonth);
        return financialLiabilities.stream()
                .map(FinancialLiabilityEntity::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Double getMonthlyInflation(String date) {
        log.info("Fetching inflation index for date: {}", date);
        return inflationIndexService.getInflationIndexByDate(date)
                .stream()
                .findFirst()
                .map(InflationIndexDto::getIndexValue)
                .orElseThrow(() -> new RuntimeException("Inflation index not found for the given date"));
    }

    private BigDecimal getLastTotalBalance(String accountId, Month currentMonth) {
        Month previousMonth = currentMonth.minus(1);
        FinancialBalanceEntity previousBalance = financialBalanceRepository.findByAccountIdAndReferenceMonth(accountId, previousMonth);
        return previousBalance != null ? previousBalance.getTotalBalance() : BigDecimal.ZERO;
    }

    private Double calculateRealGrowthPercentage(BigDecimal lastTotal, BigDecimal currentTotal, Double inflation) {
        if (lastTotal.compareTo(BigDecimal.ZERO) == 0) {
            return 100.0;
        }

        BigDecimal growth = currentTotal.subtract(lastTotal);
        BigDecimal growthPercentage = growth.divide(lastTotal, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));

        return growthPercentage.doubleValue() - inflation;
    }
}

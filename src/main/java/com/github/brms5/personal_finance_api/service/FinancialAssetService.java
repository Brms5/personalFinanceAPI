package com.github.brms5.personal_finance_api.service;

import com.github.brms5.personal_finance_api.dto.FinancialAssetDto;
import com.github.brms5.personal_finance_api.mapper.FinancialAssetEntityMapper;
import com.github.brms5.personal_finance_api.repository.FinancialAssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinancialAssetService {

    private final FinancialAssetRepository financialAssetRepository;

    public void addFinancialAsset(FinancialAssetDto financialAssetDto) {
        financialAssetRepository.save(FinancialAssetEntityMapper.mapToEntity(financialAssetDto));
    }
}

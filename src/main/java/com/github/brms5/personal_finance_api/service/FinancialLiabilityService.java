package com.github.brms5.personal_finance_api.service;

import com.github.brms5.personal_finance_api.dto.FinancialLiabilityDto;
import com.github.brms5.personal_finance_api.mapper.FinancialLiabilityEntityMapper;
import com.github.brms5.personal_finance_api.repository.FinancialLiabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinancialLiabilityService {

    private final FinancialLiabilityRepository financialLiabilityRepository;

    public void addFinancialLiability(FinancialLiabilityDto financialLiabilityDto) {
        financialLiabilityRepository.save(FinancialLiabilityEntityMapper.mapToEntity(financialLiabilityDto));
    }
}

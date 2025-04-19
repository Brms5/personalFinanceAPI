package com.github.brms5.personal_finance_api.service;

import com.github.brms5.personal_finance_api.dto.FinancialLiabilityDto;
import com.github.brms5.personal_finance_api.entity.FinancialLiabilityEntity;
import com.github.brms5.personal_finance_api.mapper.FinancialLiabilityDtoMapper;
import com.github.brms5.personal_finance_api.mapper.FinancialLiabilityEntityMapper;
import com.github.brms5.personal_finance_api.repository.FinancialLiabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialLiabilityService {

    private final FinancialLiabilityRepository financialLiabilityRepository;

    public FinancialLiabilityDto addFinancialLiability(FinancialLiabilityDto financialLiabilityDto) {
        FinancialLiabilityEntity financialLiabilityEntity = financialLiabilityRepository.save(FinancialLiabilityEntityMapper.mapToEntity(financialLiabilityDto));
        return FinancialLiabilityDtoMapper.mapEntityToDto(financialLiabilityEntity);
    }

    public List<FinancialLiabilityDto> getAllFinanceLiabilityByAccountIdAndReferenceMonth(FinancialLiabilityDto financialLiabilityDto) {
        List<FinancialLiabilityEntity> financialLiabilityEntities = financialLiabilityRepository.findAllByAccountIdAndReferenceMonth(
                financialLiabilityDto.getAccountId(), financialLiabilityDto.getReferenceMonth());
        return financialLiabilityEntities.stream()
                .map(FinancialLiabilityDtoMapper::mapEntityToDto)
                .toList();
    }

    public FinancialLiabilityDto updateFinancialLiability(FinancialLiabilityDto financialLiabilityDto) {
        FinancialLiabilityEntity financialLiabilityEntity = financialLiabilityRepository.findById(financialLiabilityDto.getId())
                .orElseThrow(() -> new RuntimeException("Financial liability not found"));

        financialLiabilityEntity.setName(financialLiabilityDto.getName());
        financialLiabilityEntity.setType(financialLiabilityDto.getType());
        financialLiabilityEntity.setTotalAmount(financialLiabilityDto.getTotalAmount());
        financialLiabilityEntity.setRemainingAmount(financialLiabilityDto.getRemainingAmount());
        financialLiabilityEntity.setInterestRate(financialLiabilityDto.getInterestRate());
        financialLiabilityEntity.setInstallments(financialLiabilityDto.getInstallments());
        financialLiabilityEntity.setCreditor(financialLiabilityDto.getCreditor());
        financialLiabilityEntity.setStatus(financialLiabilityDto.getStatus());
        financialLiabilityEntity.setNotes(financialLiabilityDto.getNotes());
        financialLiabilityEntity.setUpdatedAt(LocalDateTime.now());

        return FinancialLiabilityDtoMapper.mapEntityToDto(financialLiabilityRepository.save(financialLiabilityEntity));
    }
}
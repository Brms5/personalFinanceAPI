package com.github.brms5.personal_finance_api.service;

import com.github.brms5.personal_finance_api.dto.FinancialAssetDto;
import com.github.brms5.personal_finance_api.entity.FinancialAssetEntity;
import com.github.brms5.personal_finance_api.mapper.FinancialAssetDtoMapper;
import com.github.brms5.personal_finance_api.mapper.FinancialAssetEntityMapper;
import com.github.brms5.personal_finance_api.repository.FinancialAssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FinancialAssetService {

    private final FinancialAssetRepository financialAssetRepository;

    public FinancialAssetDto addFinancialAsset(FinancialAssetDto financialAssetDto) {
        FinancialAssetEntity financialAssetEntity = financialAssetRepository.save(FinancialAssetEntityMapper.mapToEntity(financialAssetDto));
        return FinancialAssetDtoMapper.mapEntityToDto(financialAssetEntity);
    }

    public List<FinancialAssetDto> getAllFinancialAssetsByAccountIdAndReferenceMonth(FinancialAssetDto financialAssetDto) {
        List<FinancialAssetEntity> financialAssetEntities = financialAssetRepository.findAllByAccountIdAndReferenceMonth(
                financialAssetDto.getAccountId(), financialAssetDto.getReferenceMonth());
        return financialAssetEntities.stream()
                .map(FinancialAssetDtoMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public FinancialAssetDto updateFinancialAsset(FinancialAssetDto financialAssetDto) {
        FinancialAssetEntity financialAssetEntity = financialAssetRepository.findById(financialAssetDto.getId())
                .orElseThrow(() -> new RuntimeException("Financial asset not found"));

        financialAssetEntity.setName(financialAssetDto.getName());
        financialAssetEntity.setType(financialAssetDto.getType());
        financialAssetEntity.setValue(financialAssetDto.getValue());
        financialAssetEntity.setAcquisitionDate(financialAssetDto.getAcquisitionDate());
        financialAssetEntity.setInstitution(financialAssetDto.getInstitution());
        financialAssetEntity.setNotes(financialAssetDto.getNotes());
        financialAssetEntity.setUpdatedAt(LocalDateTime.now());

        return FinancialAssetDtoMapper.mapEntityToDto(financialAssetRepository.save(financialAssetEntity));
    }
}

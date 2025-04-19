package com.github.brms5.personal_finance_api.repository;

import com.github.brms5.personal_finance_api.entity.FinancialAssetEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface FinancialAssetRepository extends MongoRepository<FinancialAssetEntity, String> {

    List<FinancialAssetEntity> findAllByAccountIdAndReferenceMonth(String accountId, Month referenceMonth);
}
package com.github.brms5.personal_finance_api.repository;

import com.github.brms5.personal_finance_api.entity.FinancialLiabilityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface FinancialLiabilityRepository extends MongoRepository<FinancialLiabilityEntity, String> {

    List<FinancialLiabilityEntity> findAllByAccountIdAndReferenceMonth(String accountId, Month referenceMonth);
}
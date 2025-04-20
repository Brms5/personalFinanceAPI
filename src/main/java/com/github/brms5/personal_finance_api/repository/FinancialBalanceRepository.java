package com.github.brms5.personal_finance_api.repository;

import com.github.brms5.personal_finance_api.entity.FinancialBalanceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;

@Repository
public interface FinancialBalanceRepository extends MongoRepository<FinancialBalanceEntity, String> {
    FinancialBalanceEntity findByAccountIdAndReferenceMonth(String accountId, Month referenceMonth);
}
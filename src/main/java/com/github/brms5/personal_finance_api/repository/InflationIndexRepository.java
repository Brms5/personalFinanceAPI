package com.github.brms5.personal_finance_api.repository;

import com.github.brms5.personal_finance_api.entity.InflationIndexEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InflationIndexRepository extends MongoRepository<InflationIndexEntity, String> {

    Boolean existsByDate(LocalDate date);

    List<InflationIndexEntity> findByDate(LocalDate parsedDate);
}

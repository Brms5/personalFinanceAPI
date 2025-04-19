package com.github.brms5.personal_finance_api.job;

import com.github.brms5.personal_finance_api.service.InflationIndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class RequestAndSaveInflationIndexJob {

    private final InflationIndexService inflationIndexService;

    @Scheduled(cron = "${cron.request-and-save-inflation-index}")
    public void requestAndSaveInflationIndex() {
        LocalDate today = LocalDate.now();
        Boolean isFirstDayOfMonth = today.getDayOfMonth() == 1;
        if (Boolean.FALSE.equals(isFirstDayOfMonth)) {
            return;
        }

        String firstDayOfLastMonth = today.minusMonths(1).withDayOfMonth(1).toString();
        String lastDayOfLastMonth = today.minusMonths(1).withDayOfMonth(today.minusMonths(1).lengthOfMonth()).toString();
        inflationIndexService.requestAndSaveInflationIndex(firstDayOfLastMonth, lastDayOfLastMonth);
    }
}
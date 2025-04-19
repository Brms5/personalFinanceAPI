package com.github.brms5.personal_finance_api.client;

import com.github.brms5.personal_finance_api.client.response.GetInflationIndexResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InflationIndexClient {

    private final InflationIndexFeignClient client;

    public InflationIndexClient(InflationIndexFeignClient client) { this.client = client; }

    public List<GetInflationIndexResponse> getInflationIndex(String format, String startDate, String endDate) {
        return client.getInflationIndex(format, startDate, endDate);
    }
}
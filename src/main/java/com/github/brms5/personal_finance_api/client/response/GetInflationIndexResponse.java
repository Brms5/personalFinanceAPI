package com.github.brms5.personal_finance_api.client.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetInflationIndexResponse {

    private String data;
    private String valor;
}

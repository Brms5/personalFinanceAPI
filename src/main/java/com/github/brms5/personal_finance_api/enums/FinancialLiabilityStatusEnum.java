package com.github.brms5.personal_finance_api.enums;

public enum FinancialLiabilityStatusEnum {
    ACTIVE,       // Ongoing debt, payments still required
    PENDING,      // Liability has been created but not yet confirmed/started
    PAID_OFF,     // Fully paid, no more balance
    OVERDUE,      // Missed one or more payments
    DEFAULTED,    // Considered uncollectible / in default
    SUSPENDED,    // Temporarily paused (e.g., payment holiday)
    CLOSED        // Officially closed, no further actions
}
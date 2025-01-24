package com.codeseek.footballmanager.service;

import java.math.BigDecimal;

public interface CalculationService {
    double PLAYER_VALUE_MULTIPLIER = 100000.0;
    int COMMISSION_DIVIDER = 100;
    int MAX_TRANSFER_COMMISSION = 10;

    BigDecimal calculateTransferAmount(int experienceInMonths, int age);

    BigDecimal calculateCommission(BigDecimal transferValue, double commissionRate);
}

package com.codeseek.footballmanager.service;

import java.math.BigDecimal;

public interface CalculationService {

    BigDecimal calculateTransferAmount(int experienceInMonths, int age);

    BigDecimal calculateCommission(BigDecimal transferValue, double commissionRate);
}

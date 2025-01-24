package com.codeseek.footballmanager.service.impl;

import com.codeseek.footballmanager.service.CalculationService;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    public BigDecimal calculateTransferAmount(int playerExperience, int playerAge) {
        return BigDecimal.valueOf(playerExperience * 100000.0 / playerAge);
    }

    @Override
    public BigDecimal calculateCommission(BigDecimal transferValue, double commissionRate) {
        if (commissionRate < 0 || commissionRate > 10) {
            throw new IllegalArgumentException("Commission rate hast to be between 0 and 10 percents");
        }
        return transferValue.multiply(BigDecimal.valueOf(commissionRate / 100));
    }
}

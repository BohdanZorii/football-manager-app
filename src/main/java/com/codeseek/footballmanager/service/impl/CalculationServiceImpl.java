package com.codeseek.footballmanager.service.impl;

import com.codeseek.footballmanager.service.CalculationService;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    public BigDecimal calculateTransferAmount(int playerExperience, int playerAge) {
        return BigDecimal.valueOf(playerExperience * PLAYER_VALUE_MULTIPLIER / playerAge);
    }

    @Override
    public BigDecimal calculateCommission(BigDecimal transferValue, double commissionRate) {
        if (commissionRate < 0 || commissionRate > MAX_TRANSFER_COMMISSION) {
            throw new IllegalArgumentException("Commission rate has to be between 0 and "
                + MAX_TRANSFER_COMMISSION);
        }
        return transferValue.multiply(BigDecimal.valueOf(commissionRate / COMMISSION_DIVIDER));
    }
}

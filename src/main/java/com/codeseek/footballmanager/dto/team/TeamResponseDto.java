package com.codeseek.footballmanager.dto.team;

import java.math.BigDecimal;
import java.util.UUID;

public record TeamResponseDto(
    UUID id,
    String name,
    BigDecimal budget,
    double commissionRate
) {}

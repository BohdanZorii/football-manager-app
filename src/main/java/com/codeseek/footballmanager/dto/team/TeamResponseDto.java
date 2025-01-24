package com.codeseek.footballmanager.dto.team;

import java.util.UUID;

public record TeamResponseDto(
    UUID id,
    String name,
    double budget,
    double commissionRate
) {}

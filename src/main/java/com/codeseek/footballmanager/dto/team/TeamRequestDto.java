package com.codeseek.footballmanager.dto.team;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TeamRequestDto(
    @NotNull(message = "Team name cannot be null")
    @Size(min = 2, max = 100, message = "Team name should be between 2 and 100 characters")
    String name,
    @Min(value = 0, message = "Budget cannot be negative")
    double budget,
    @Min(value = 0, message = "Commission rate cannot be negative")
    @Max(value = 10, message = "Commission rate must be less than 10")
    double commissionRate
) {
}

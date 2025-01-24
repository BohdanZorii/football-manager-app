package com.codeseek.footballmanager.dto.team;

import static com.codeseek.footballmanager.service.CalculationService.MAX_TRANSFER_COMMISSION;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record TeamRequestDto(
    @NotBlank(message = "Team name cannot be blank")
    @Size(min = 2, max = 100, message = "Team name should be between 2 and 100 characters")
    String name,
    @Min(value = 0, message = "Budget cannot be negative")
    BigDecimal budget,
    @Min(value = 0, message = "Commission rate cannot be negative")
    @Max(value = MAX_TRANSFER_COMMISSION,
        message = "Commission rate must be less than " + MAX_TRANSFER_COMMISSION)
    double commissionRate
) {

}

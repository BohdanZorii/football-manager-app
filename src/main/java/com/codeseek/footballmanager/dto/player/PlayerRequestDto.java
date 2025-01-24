package com.codeseek.footballmanager.dto.player;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;

public record PlayerRequestDto(
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    String name,
    @Min(value = 18, message = "Age must be at least 18")
    int age,
    @Min(value = 1, message = "Experience in months must be at least 1")
    int experienceInMonths,
    @NotNull(message = "Team ID cannot be null")
    UUID teamId
) {
}

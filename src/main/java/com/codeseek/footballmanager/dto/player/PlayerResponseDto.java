package com.codeseek.footballmanager.dto.player;

import java.util.UUID;

public record PlayerResponseDto(
    UUID id,
    String name,
    int age,
    int experienceInMonths,
    String teamName
) {
}

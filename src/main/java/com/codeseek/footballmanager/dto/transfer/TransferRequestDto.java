package com.codeseek.footballmanager.dto.transfer;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record TransferRequestDto(
    @NotNull(message = "Player ID cannot be null")
    UUID playerId,
    @NotNull(message = "To Team ID cannot be null")
    UUID toTeamId
) {
}

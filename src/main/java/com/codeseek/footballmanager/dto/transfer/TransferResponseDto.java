package com.codeseek.footballmanager.dto.transfer;

import java.math.BigDecimal;
import java.util.UUID;

public record TransferResponseDto(
    UUID id,
    UUID playerId,
    UUID fromTeamId,
    UUID toTeamId,
    BigDecimal transferAmount,
    BigDecimal commission
) {
}
